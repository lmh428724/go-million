@echo off
echo Stopping application
call stop.bat
echo Starting application
start "Start go-million" cmd /k call startup.bat
