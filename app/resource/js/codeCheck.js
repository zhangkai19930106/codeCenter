
/*验证机构代码有效性*/
function codeCheck(code){
			  var codeArray=new Array(8);
			  var codeFactor=new Array(8);
			  var verifyChar;
			
			  for(var i=0;i<8;i++){
			    var tmpChar=code.substring(i,i+1);
			    if(isNaN(tmpChar)){
			      	codeArray[i]=tmpChar.charCodeAt(0)-65+10;
			    }else{
			      	codeArray[i]=parseInt(tmpChar);
			    }
			  }
			 
			  endChar=code.substring(8,9);
			  codeFactor[0] = 3;
			  codeFactor[1] = 7;
			  codeFactor[2] = 9;
			  codeFactor[3] = 10;
			  codeFactor[4] = 5;
			  codeFactor[5] = 8;
			  codeFactor[6] = 4;
			  codeFactor[7] = 2;
			  
			  var j1 = 0;
			  for(var i=0;i<8;i++){
			   	 j1=j1+codeArray[i]*codeFactor[i];
			  }
			  
			  j1=j1%11;
			  j1=11-j1;
			  switch(j1){
			    case 11:
			      verifyChar="0";
			      break;
			    case 10:
			      verifyChar="X";
			      break
			    default:
			      verifyChar=String(j1);  
			  }
			  
			  if(endChar==verifyChar){
			   	 return true;
			  }else{
			    	return false;
			  }     
}
