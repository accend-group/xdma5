# Genentech-Screenshots
Screenshot automation for Access Solutions, Kadcyla HCP, and Kadcyla Patient sites.

### Pre-requisites:
1) Node JS (>v4): `brew install node`
2) Maven 3.x: `brew install maven`
3) Jenkins: `brew install jenkins`

### Set up

1. Install [Jenkins](https://jenkins.io/download/) for your testing environment. Once installation is complete, go to localhost:8080 in your browser. First time users will be prompted for a password. The admin password is stored in `~/.jenkins/secrets/initialAdminPassword`. After entering the password, users will want to select "Install suggested plugins"

2. Now you need to set the AWS credentials and Github credentials. If the AWS credentials for the S3 service are [locally saved](http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-credentials.html#setup-credentials-setting) you can decide to either use the local credentials or specify the credentials to Jenkins. Skip step 6 if using local credentials. 

   On the Jenkins dashboard on the left click "Credentials".

   ![](./readmepics/credentials.png) 

   Then under "Stores scoped to Jenkins" click "Jenkins". 
   
   ![](./readmepics/scope.png)

   Now click on "Global credentials". On the far left click "Add Credentials". Here you will specify the credential type and required login/key information. For S3 services set the kind to "Username and password". For Github set the kind to "SSH Username with private key".
   
   ![](./readmepics/set_credentials.png)

3. Once the credentials are filled in. Return to the dashboard by clicking on the Jenkins logo on the top left. At the dashboard click "New Item" on the far left. Here we are creating a new Job. Set the name of the Job and click "Freestyle project". Then click "Ok". 

   ![](readmepics/job.png)

   Once the Job is created set in the required parameters for the Job. The screenshot automation takes in several arguments and each parameter is associated to an argument. In the General tab check "This project is parameterizd." Then click "Add parameter." From the list select the appropriate type.
   
   ![](./readmepics/set_params.png)
   
   Fill in the parameter details. Default values will be used when a job gets built automatically. Then click "Add Parameter" to add the next parameter. Repeat adding parameters until all the needed parameters are set. 
   
   For choice parameters you need to list the choices per line.
   ![](./readmepics/domain.png)
   
   For string parameters place the needed value in the "Default Value" field.
   ![](./readmepics/threads.png)
   
   For boolean parameters check the box to set the parameter to be true.
   ![](./readmepics/aws_local.png)

   Below are all the parameters.

   |  Name            |  Type |Description | 
   | -------------    | --- |--- |
   | DEVELOPMENT_ENVIRONMENT | choice (`dev` `stage` `prod` `local`)  | Run the screenshot automation on a developer, stage, production, or local environment | 
   | JOB_TYPE | choice (`Access_Solutions` `Kadcyla_HCP` `Kadcyla_Patient`)| Runs a specific automation job for either Access Solutions, Kadcyla HCP or Kadcyla Patients
   | THREAD_COUNT | string | Integer value representing the number of allowed threads of WebDriver workers. Default value is 1. Make sure the value is reasonable for the system. | 
   | SAVE_PATH         | string |Path where the screenshots and logs are saved |
   | PDF_OUTPUT_PATH  | string |Path to created PDF. If not set defaults to SAVE_PATH | 
   | PDF_NAME         | string |Name of PDF. If not set defaults to automation class name|
   | S3               | boolean |Send generated pdfs to an S3 Service if set to TRUE| 
   | S3_BUCKET        | string |Name of Bucket where PDF is stored |
   | S3_PDF_KEY       | string |Name of key for PDF |
   | S3_REGION        | string |Region where the bucket is at. Defaults to us-east-1 |
   | AWS_LOCAL        | boolean |Uses local AWS credentials if TRUE |

4. Under Source Code management check Git and set the URL of the Github repository of the automation code. Then set the git credentials underneath for repo access. 

   Select the branch where the automation code resides.

5. Under Build Trigger determine what your needs will be (polling for commits, run between time periods).

6. If the setup requires using the AWS login and password credentials under Build Environment check "Use secret text(s) or files(s)". 
   
   ![](./readmepics/secret.png) 

   Then under Bindings click add and select Username and password (conjoined). 
   
   ![](readmepics/binding.png)

   Select "Specific credentials" and select the AWS credentials set from step 2. Now for "Username Variable" set the value to AWS_ACCESS_KEY and the "Password Variable" to AWS_SECRET_KEY.
   Now the AWS credentials and set parameters from step 3 are usable in the shell/bash.
   
   | Name | Type |
   | --- | --- |
   | ACCESS_KEY | Username Variable |
   | SECRET_KEY | Password Variable |

7. Mac OS/Linux
   
   Under "Build", click "Add Setup" then select "Execute Shell". If you are a Windows user, Maven and npm needs to be installed beforehand.
   In the command textbox set the build commands to the following below.
   
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
           pdfname=$PDF_NAME \
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
