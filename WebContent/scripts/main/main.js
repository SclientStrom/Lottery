var redBallCount=0;
var blueBallCount=0;
var childLen=0;
var url="confirmLottery.json";
var buyUrl="payConfirm.json";
var balls = [ '00','01', '02', '03', '04', '05', '06', '07', '08', '09', '10', 
              '11', '12', '13', '14', '15', '16', '17', '18', '19',
              '20','21', '22', '23', '24', '25', '26', '27', '28', '29',
              '30','31','32','33'];
$(document).ready(function(){
	hiddenPointAndBet();
	$("a").click(function(){
		var index=$('a').index(this);
		if($(this).hasClass("js_ball") && index>32){
			$(this).css("background","url(images/ball_blue.png) 0 0 no-repeat");
			$(this).css("color","white");
			$(this).removeClass("js_ball");
			$(this).addClass("js_ball_selected");
			blueBallCount =blueBallCount+1;
		}else if($(this).hasClass("js_ball_selected")){
			$(this).css("background","url(images/ball_gray.png) 0 0 no-repeat");
			$(this).removeClass("js_ball_selected");
			$(this).addClass("js_ball");
			if(index>32){
				$(this).css("color","blue");
				blueBallCount=blueBallCount-1;
			}else{
				$(this).css("color","red");
				redBallCount=redBallCount-1;
			}
		}else if($(this).hasClass("js_ball") && index<=32){
			$(this).css("background","url(images/ball_red.png) 0 0  no-repeat ");
			$(this).css("color","white");
			$(this).removeClass("js_ball");
			$(this).addClass("js_ball_selected");
			redBallCount=redBallCount+1;
		}
		ballAndRecordToTtml(redBallCount,blueBallCount);
	})
	$(".clearing").click(function () {
		$('a').each(function(){
			if($(this).hasClass('js_ball_selected')){
				var index=$('a').index(this);
				$(this).css("background","url(images/ball_gray.png) 0 0 no-repeat");
				if(index>32){
					$(this).css("color","blue");
				}else{
					$(this).css("color","red");
				}
				$(this).removeClass("js_ball_selected");
				$(this).addClass("js_ball");
			}
			redBallCount=0;
			blueBallCount=0;
			ballAndRecordToTtml(redBallCount,blueBallCount);
			$(".record").text(0);
		})
	})
	$(".confirm2").click(function(){
		var childLen=$('.listContext').children("div").length;
		if(childLen==0){
			alert("对不起，你还没有投注记录");
			return;
		}
		consumePoint();
	})
	$(".buy").click(function(){
		var buyRequest={
				"orderNo":$(".order_no").text(),
				"points":$(".allPoints").text()
		}
		$.ajax({
			  type: 'post',
			  url: buyUrl,
			  data: buyRequest,
			  dataType: 'json',
			  success: function(data){
				 alter(JSON.stringify(data));
			  }
			});
	})
	$(".confirm").click(function(){
		if(redBallCount<6 || blueBallCount<1){
			alert("请至少选择6个红球，1个蓝球");
		}else{
			var redBallNums="";
			var blueBallNums="";
			var betType;
			$("a").each(function(){
				if($("a").index(this)>32  && $(this).hasClass('js_ball_selected')){
					blueBallNums+=$(this).attr("data-value") +" ";
				}else if($(this).hasClass('js_ball_selected')){
					redBallNums+=$(this).attr("data-value") +" ";
				}
			});
			var betcount=$(".record").text();
			if(redBallCount==6 && blueBallCount==1 ){
				betType="单式";
			}else{
				betType="复式";
			}
			showListRecord(redBallNums,blueBallNums,betcount,betType);
			$(".main").hide();
			$(".list").show();
		}
	})
	$(".list").hide();
	$(".select").click(function (){
		$('a').each(function(){
			if($(this).hasClass('js_ball_selected')){
				var index=$('a').index(this);
				$(this).css("background","url(images/ball_gray.png) 0 0 no-repeat");
				if(index>32){
					$(this).css("color","blue");
				}else{
					$(this).css("color","red");
				}
				$(this).removeClass("js_ball_selected");
				$(this).addClass("js_ball");
			}
			redBallCount=0;
			blueBallCount=0;
			ballAndRecordToTtml(redBallCount,blueBallCount);
			$(".record").text(0);
		})
		$(".main").show();
		$(".list").hide();
		hiddenPointAndBet();
	})
	$(".oneSelect").click(function (){
		var redBall=randomNum(6,33);
		var blueBall=randomNum(1,16);
		showListRecord(redBall,blueBall,1,"单式");
		hiddenPointAndBet();
	})
})
function showListRecord(redBallNums,blueBallNums,betcount, betType){
	childLen=childLen+1;
	var delId="DelId"+childLen;
	$("div[class='listContext']").prepend("<div class='"+delId+"' redBall='"+redBallNums+"' blueBall='"+blueBallNums+"' count='"+betcount+"'>" +
			"<img src='images/candle.gif' onclick=deleteRecord('"+delId+"')  >"+betType+"<span class='redStyle'>&nbsp;"+redBallNums+"</span>&nbsp;|&nbsp;<span class='blueStyle'>"+
			blueBallNums+"</span>&nbsp;&nbsp;&nbsp;"+
			betcount+"注</div>");
}
function deleteRecord(delId){
	$("."+delId).remove();
}
function clearList(){
	var childLen=$('.listContext').children("div").length;
	if(childLen==0){
		return;
	}
	var r=confirm("你确定要清空当前的投注内容!");
	if (r==true){
		$(".listContext").empty();
		childLen=0;
		$(".allBetCounts").text(0);
	}
	hiddenPointAndBet();
}

function ballAndRecordToTtml(redCount,blueCount){
	$(".redCount").text(redCount);
	$(".blueCount").text(blueCount);
	if(redCount>=6 && blueCount>=1){
		$(".record").text(recordToTtml(redCount,blueCount,"ssq"));
	}
}
function consumePoint(){
	//mileageCard=70&surName=23&givenName=456&cardNo=23454&phone=1328765372&channel=MN
//	alert(jQuery.parseJSON(userInfo));
	var data={
			"mileageCard":$(".mileageCard").text(),
			"surName":$(".surName").text(),
			"givenName":$(".givenName").text(),
			"cardNo":$(".cardNo").text(),
			"cardType":$(".cardType").text(),
			"phone":$(".phone").text(),
			"channel":$(".channel").text(),
			"times":$(".times").text()
	};
	var index=0;
	$(".listContext div").each(function(){
//		var record = {"redRecord":$(this).attr("redBall")+"", "blueRecord":$(this).attr("blueBall")+""};
//		var record = {"redRecord":"12", "blueRecord":"23"};
//		recordInfo.push(record);
		data['lotteryRecords[' + index +'].redRecord'] = $(this).attr("redBall");
		data['lotteryRecords[' + index +'].blueRecord'] = $(this).attr("blueBall");
		index++;
	});
//	alert(JSON.stringify(data));
	$.ajax({
		  type: 'post',
		  url: url,
		  data: data,
		  dataType: 'json',
		  success: function(callbackData){
			  betNeedCountPoint(callbackData);
		  }
		});
}
function betNeedCountPoint(date){
	showPiontAndBet();
	$(".allBetCounts").text(date.betCount);
	$(".allPoints").text("  "+date.points+" 积分");
	$(".order_no").text(date.orderNo);
}
function randomNum(index,maxNum){
	var res = "";
	var i=1;
	while(i<=index){
		var id = Math.ceil(Math.random()*maxNum);
	    if(id >= 0 && res.indexOf(balls[id]) < 0){
	    	res +=balls[id]+" ";
	    	i+=1;
	    }
	}
	return res;
}
function recordToTtml(redcount,blueCount,type){
	var record=1;
	if(type=="ssq"){
		record=record*blueCount;
		for(var i=1;i<=6;i++){
			record=record*(redcount)/i;
			redcount=redcount-1;
		}
	}
	return record;
}
function subNum(){
	var times=$(".times").text();
	if(times==1){
		return;
	}
	$(".times").text(times-1);
}
function addNum(){
	var times=$(".times").text();
	$(".times").text(parseInt(times)+1);
}
function hiddenPointAndBet(){
	$(".confirm2").show();
	$(".buy").hide();
	$(".allBet").hide();
	$(".allPoints").hide();
}
function showPiontAndBet(){
	$(".confirm2").hide();
	$(".buy").show();
	$(".allBet").show();
	$(".allPoints").show();
}
