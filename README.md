# Genentech-Screenshots

###Pre-requisites:
1) Node JS (>v4): `brew install node`

2) Jenkins: `brew install jenkins`

### Set up
Jenkins (optionally a Selenium Standalone Server) and access to a S3 service are required.

Configure Jenkins with a Job listening for repo commits of Selenium testing code. The testing code must create a log file storing the screenshot names (no image extensions) in sequence of how it will appear in a pdf.

```
/path-to-log-file/
    - log.txt
    - png images...
```
    
Have the Jenkins Job do another build or post build to execute PostRun with the specified arguments. PostRun will generate the pdf from the log file.

```
// download chromedriver and geckoderiver
npm install
// sample run reading log file and uploading the pdf using local aws credentials
mvn compile;
mvn exec:java -Dexec.mainClass="com.gene.screenshots.PostRun" -Dexec.cleanupDaemonThreads=false "-Dexec.args=logPath=/Users/anthony/Desktop/SeleniumScriptLog pdfName=mypdf.pdf s3=true s3-bucket=pdf-screenshot-test s3-pdfKey=pdfkey aws-local=true"
```

Arguments are:

- logPath="log.txt path" - where the images and log file are saved at.
- pdfOutput="pdf output path" - where the pdf is saved.
- pdfName="my_pdf_name.pdf" - (optional) default is postRun.pdf

If storing the pdf to amazon S3 all 3 arguments below must be given and credentials must be set
- s3="true" - if storing pdf at s3 server
- s3-bucket="bucket name where pdf will be stored"
- s3-pdfKey="key for storing pdf"
- s3-region="region location" - (optional) default is us-east-1

Either local or manual credentials must be set
- aws-local="true" - uses aws credentials stored in user's credential file.
- aws-accesskey="access key"
- aws-secretkey="secret access key"

