// This is a test harness for your module
// You should do something interesting in this harness 
// to test out the module and to provide instructions 
// to users on how to use it by example.
function neverCalled() { Ti.Media.showCamera(); }

// open a single window
var window = Ti.UI.createWindow({
	backgroundColor:'white',
	layout: 'vertical'
});
var label = Ti.UI.createLabel();
window.add(label);

// TODO: write your module tests here
var moddummy = require('com.mandarinmedien.module.camerastream');

var myButton = Ti.UI.createButton({title:'test'});
myButton.addEventListener("click",function()
		{  
			alert("click");
			moddummy.startCameraStream();
			Ti.API.debug("MUH");
			Ti.API.debug(moddummy.byteImage);
			Ti.API.debug("END MUH");
		});
window.add(myButton);

var myButtonCheck = Ti.UI.createButton({title:'ckeck'});
myButtonCheck.addEventListener("click",function()
		{  
			alert("Check");
			Ti.API.debug("MUH");
			Ti.API.debug(moddummy.byteImage);
			Ti.API.debug("END MUH");
		});
window.add(myButtonCheck);

var myButtonClose = Ti.UI.createButton({title:'Close'});
myButtonClose.addEventListener("click",function()
		{  
			moddummy.stopCameraStream();
			Ti.API.debug("closed");
		});
window.add(myButtonClose);



if (Ti.Platform.name == "android") {
	var proxy = moddummy.createExample({message: "Creating an example Proxy"});
	proxy.printMessage("Hello world!");
}

window.open();

/*
// open a single window
var window = Ti.UI.createWindow({
	backgroundColor:'white'
});
var label = Ti.UI.createLabel();
var label2 = Ti.UI.createLabel();
window.add(label);
window.add(label2);
window.open();

// TODO: write your module tests here
var tiexample = require('com.mandarinmedien.module.tiexample');
Ti.API.info("module is => " + tiexample);
alert(tiexample);
label.text = tiexample.example();

Ti.API.info("module exampleProp is => " + tiexample.exampleProp);
tiexample.exampleProp = "This is a test value EINS EINS ELF!!!";

label.text = tiexample.exampleProp;

if (Ti.Platform.name == "android") {
	var proxy = tiexample.createExample({message: "Creating an example Proxy"});
	proxy.printMessage("Hello world!");
}*/