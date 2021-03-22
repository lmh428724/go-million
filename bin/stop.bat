echo off
setlocal enabledelayedexpansion
for /f "tokens=1-2 delims==" %%i in (startup.bat) do (
	set flag=no
	echo %%i | findstr SERVER_PORT >nul && set flag=yes
	rem echo !flag!
    if "!flag!" == "yes" (
        echo "####",%%i,%%j
		for /f "tokens=1-5" %%a in ('netstat -ano ^| find ":%%j"') do (
			if "%%e%" == "" (
				set pid=%%d
			) else (
				set pid=%%e
			)
			echo !pid!
			taskkill /f /pid !pid!
		)
    )
)