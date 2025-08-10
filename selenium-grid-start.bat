@echo off
REM ==============================
REM Selenium Grid Hub + Node Startup Script
REM ==============================

REM ==== CONFIGURATION ====
REM Full path to Selenium Server jar
set SELENIUM_JAR=D:\Projects\Udemy\Seleniumgrid\selenium-server-4.34.0.jar

REM Path to WebDrivers folder
set DRIVER_PATH=C:\bin

REM =======================

REM Add driver folder to PATH for this session
set PATH=%PATH%;%DRIVER_PATH%

REM Check if Selenium jar exists
if not exist "%SELENIUM_JAR%" (
    echo ERROR: Could not find Selenium jar at %SELENIUM_JAR%
    pause
    exit /b 1
)

REM Start Selenium Hub in a new window
start "Selenium Hub" cmd /k java -jar "%SELENIUM_JAR%" hub

REM Small delay to ensure Hub starts before Node connects
timeout /t 5 /nobreak >nul

REM Start Selenium Node in a new window
start "Selenium Node" cmd /k java -jar "%SELENIUM_JAR%" node --detect-drivers true --hub http://localhost:4444

echo Selenium Grid Hub and Node started successfully.
pause
