# Genentech-Screenshots
Screenshot automation for Access Solutions, Kadcyla HCP, and Kadcyla Patient sites.

### Pre-requisites:
1) Node JS (>v4): `brew install node`
3) Maven
2) Jenkins: `brew install jenkins`

### Set up

Create a Jenkins Job that clones this repo and has the following parameters. 

|  Name            |  Type |Description | 
| -------------    | --- |--- |
| DOMAIN | choice (`dev` `stage` `prod` `local`)  | Run the screenshot automation on a developer, stage, production, or local environment | 
| JOB_TYPE | choice (`Access_Solutions` `Kadcyla_HCP` `Kadcyla_Patient`)| Runs a specific automation job for either Access Solutions, Kadcyla HCP or Kadcyla Patients
| THREAD_COUNT | string | Integer value representing the number of allowed threads of WebDriver workers. Default value is 1. Make sure the value is reasonable for the system. | 
| CHROMEDRIVER_PATH| string |Path to the chromedriver. If not set defaults to the [latest](https://www.npmjs.com/package/chromedriver) from ```npm install``` |
| SAVE_PATH         | string |Path where the screenshots and logs are saved |
| PDF_OUTPUT_PATH  | string |Path to created PDF. If not set defaults to SAVE_PATH | 
| PDF_NAME         | string |Name of PDF. If not set defaults to automation class name|
| S3               | boolean |Send generated pdfs to an S3 Service if set to TRUE| 
| S3_BUCKET        | string |Name of Bucket where PDF is stored |
| S3_PDF_KEY       | string |Name of key for PDF |
| S3_REGION        | string |Region where the bucket is at. Defaults to us-east-1 |
| AWS_LOCAL        | boolean |Uses local AWS credentials if TRUE |

If the [local aws credential file](http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-credentials.html#setup-credentials-setting) is not being used the automation job can take in the access key and secret access key with the [Credentials Binding plugin](https://wiki.jenkins.io/display/JENKINS/Credentials+Binding+Plugin). Create a credential and bind the separated username and password.

| Name | Type |
| --- | --- |
| ACCESS_KEY | Username Variable |
| SECRET_KEY | Password Variable |


Have the Jenkins Job build this in the shell/bash

> Downloads chromedriver
```
npm install
```
> Build and run the automation job, remove the ACCESS_KEY and SECRET_KEY if they are not set. 
```
mvn compile exec:java \
    -Dexec.cleanupDaemonThreads=false \
    -Dexec.args=" \
        savepath=$SAVE_PATH \
        pdfoutput=$PDF_OUTPUT_PATH \ 
        s3=$S3 \
        aws-local=$AWS_LOCAL \ 
        s3-bucket=$S3_BUCKET \
        s3-pdfkey=$S3_PDF_KEY \
        s3-region=$S3_REGION \
        jobtype=$JOB_TYPE \
        domain=$DOMAIN \
        threadcount=$THREAD_COUNT \
        aws-accesskey=$ACCESS_KEY \
        aws-secretkey=$SECRET_KEY" 
```
Now modify the Build Triggers for your needs.
