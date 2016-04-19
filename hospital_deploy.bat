
start /D "d:\dev\tomcat\bin"  shutdown.bat
timeout 5
rmdir /S /Q "D:\dev\tomcat\webapps\hospital"
md d:\dev\tomcat\webapps\hospital
xcopy "d:\workspace\Task4_Var5\src\webapp\*.*" "D:\dev\tomcat\webapps\hospital\*.*" /S /E
md "d:\dev\tomcat\webapps\hospital\web-inf\lib"
copy "d:\workspace\Task4_Var5\lib\mysql*.*" "D:\dev\tomcat\webapps\hospital\web-inf\lib\*.*" 
copy "d:\workspace\Task4_Var5\lib\log*.*" "D:\dev\tomcat\webapps\hospital\web-inf\lib\*.*" 
copy "d:\workspace\Task4_Var5\lib\jstl*.*" "D:\dev\tomcat\webapps\hospital\web-inf\lib\*.*" 
copy "d:\workspace\Task4_Var5\lib\standard*.*" "D:\dev\tomcat\webapps\hospital\web-inf\lib\*.*" 
md d:\dev\tomcat\webapps\hospital\web-inf\classes
xcopy "d:\workspace\Task4_Var5\out\production\Task4_Var5\*.*" "D:\dev\tomcat\webapps\hospital\web-inf\classes" /S /E
start /D "d:\dev\tomcat\bin"  catalina.bat jpda start


rem pause