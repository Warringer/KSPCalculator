<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE helpset PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 1.0//EN" "http://java.sun.com/products/javahelp/helpset_1_0.dtd">
<helpset version="1.0">
 <!-- title -->
	<title>Help</title>
 <!-- maps -->
	<maps>
		<homeID>item1</homeID>
		<mapref location="help.jhm" />
	</maps>
<!-- views -->
	<view>
		<name>TOC</name>
		<label>Table Of Contents</label>
		<type>javax.help.TOCView</type>
		<data>helpTOC.xml</data>
	</view>
	
	<presentation default="true" displayviewimages="true">
     	<name>main window</name>
     	<size width="700" height="400" />
     	<location x="200" y="200" />
     	<title>KSP Calculator - Help</title>
     	<image>toplevelfolder</image>
     	<toolbar>
		<helpaction>javax.help.BackAction</helpaction>
		<helpaction>javax.help.ForwardAction</helpaction>
		<helpaction>javax.help.SeparatorAction</helpaction>
		<helpaction>javax.help.HomeAction</helpaction>
		<helpaction>javax.help.ReloadAction</helpaction>
		<helpaction>javax.help.SeparatorAction</helpaction>
		<helpaction>javax.help.PrintAction</helpaction>
		<helpaction>javax.help.PrintSetupAction</helpaction>
     	</toolbar>
  	</presentation>
  	<presentation>
     	<name>main</name>
     	<size width="400" height="400" />
     	<location x="200" y="200" />
     	<title>KSP Calculator - Help</title>
  	</presentation>
  	
</helpset>
