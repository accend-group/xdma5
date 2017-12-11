# Genentech-Screenshots
Screenshot automation for Access Solutions, Kadcyla HCP, and Kadcyla Patient sites.

###Pre-requisites:
1) Node JS (>v4): `brew install node`
2) Jenkins: `brew install jenkins`

### Set up

Create a Jenkins Job that has the following parameters. 

|  Name            |  Type |Description | 
| -------------    | --- |--- | 
| CHROMEDRIVER_PATH| string |Path to the chromedriver. If not set defaults to the [latest](https://www.npmjs.com/package/chromedriver) |
| SAVE_PATH         | string |Path where the screenshots and logs are saved |
| PDF_OUTPUT_PATH  | string |Path to created PDF. If not set defaults to SAVE_PATH | 
| PDF_NAME         | string |Name of PDF. If not set defaults to automation class name|
| S3               | boolean |Send generated pdfs to an S3 Service if set to TRUE| 
| S3_BUCKET        | string |Name of Bucket where PDF is stored |
| S3_PDF_KEY       | string |Name of key for PDF |
| S3_REGION        | string |Region where the bucket is at. Defaults to us-east-1 |
| AWS_LOCAL        | boolean |Uses local AWS credentials if TRUE |
| THREADS | boolean | If utilizing threads. Default is false |
| THREAD_COUNT | string | Integer value representing the number of allowed threads of WebDriver workers | 

```
/save-path/
    /desktop
        /TestClass    
            - png images...
   
    /mobile
        /TestClass
            - png images...
   
    /logs
        TestClass.txt
    
    TestClass.pdf
```
    
Have the Jenkins Job build this in the shell/bash

```
// download chromedriver and geckoderiver
npm install
// 
mvn compile exec:java "-Dexec.args=logpath=/Users/anthony/Documents/pics pdfoutput=testpath s3=false aws-local=true  s3-bucket=pdf-screenshots-test s3-pdfkey=newtest s3-region=us-east-1 access-solutions=true kadcyla-hcp=true kadcyla-patient=true threads=true threadcount=7"```
```

Arguments for StartTest:

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

