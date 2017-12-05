1. Install [Jenkins](https://jenkins.io/download/) for your testing environment. Once Jenkins is up go to your browser and connect to the Jenkins Server. When connected for the first time Jenkins will ask for a password stored in your system. Paste in the password and continue. Then select "Install suggested plugins" to be installed. Once the plugins finish being installed setup an Admin account.

2. Now we need to set the AWS credentials and Github credentials. If the AWS credentials for the S3 service are [locally saved](http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-credentials.html#setup-credentials-setting) the user can decide to either use their local credentials or specify the credentials to Jenkins. Skip step 6 if using local credentials. 

   On the Jenkins dashboard on the left click "Credentials".

   ![](./readmepics/credentials.png) 

   Then under "Stores scoped to Jenkins" click "Jenkins". 
   
   ![](./readmepics/scope.png)

   Now click on "Global credentials". On the far left click "Add Credentials". Here you will specify the credential type and required login/key information. For S3 services set the kind to "Username and password". For Github set the kind to "SSH Username with private key".  

3. Once the credentials are filled in. Return to the dashboard by clicking on the Jenkins logo on the top left. At the dashboard click "New Item" on the far left. Here we are creating a new Job. Set the name of the Job and click "Freestyle project". Then click "Ok". 

   ![](readmepics/job.png)

   Once the Job is created set in the required parameters for the Job. All the parameters are going to be string types.
   
   ![](./readmepics/set_params.png)

   Below are the parameters needed. Default values must be set if they are used when testing.

   |  Name            |  Description | 
   | -------------    |  --- | 
   | CHROMEDRIVER_PATH| Path to the chromedriver. If not set defaults to the [latest](https://www.npmjs.com/package/chromedriver) |
   | LOG_PATH         | Path to log.txt and png screenshots|
   | PDF_OUTPUT_PATH  | Path to created PDF. If not set defaults to LOG_PATH | 
   | PDF_NAME         | Name of PDF. If not set defaults to PostRun.pdf|
   | S3               | Tells PostRun to send the PDF to an S3 Service if set to TRUE| 
   | S3_BUCKET        | Name of Bucket where PDF is stored |
   | S3_PDF_KEY       | Name of key for PDF |
   | S3_REGION        | Region where the bucket is at. Defaults to us-east-1 |
   | AWS_LOCAL        | Sets PostRun to use local AWS credentials if TRUE |

4. Under Source Code management set the URL of the Github repository of the testing code. Set the git credentials for repo access. 

   Select the branch where the testing code is located with PostRun.

5. Under Build Trigger determine what your needs will be (polling for commits, test every time period).

6. If the setup requires using the AWS login and password credentials under Build Environment check Use secret text(s) or files(s). 
   
   ![](./readmepics/secret.png) 

   Then under Bindings click add and select Username and password (conjoined). 
   
   ![](readmepics/binding.png)

   Select "Specific credentials" and select the AWS credentials set from step 2. Now for "Username Variable" set the value to AWS_ACCESS_KEY and the "Password Variable" to AWS_SECRET_KEY.
   Now the AWS credentials and set parameters are usable in the shell/bash by using ```$NAME_OF_VAR.```

7. Under Build click "add setup" and select "Execute shell" if using mac/linx or "Windows bash" if using windows. Maven and npm are needed. Make sure both are installed and are callable in the shell/bash.
   In the command textbox set the build commands to execute your Selenium test and have PostRun run after.

   ```
   npm install;
   mvn compile;

   ...
   // Selenium script execute command here
   ...

   // modify arguments for your needs
   mvn exec:java -Dexec.mainClass="com.gene.screenshots.PostRun" -Dexec.cleanupDaemonThreads=false "-Dexec.args=logPath=$LOG_PATH pdfName=$PDF_NAME s3=$S3 s3-bucket=$S3_BUCKET s3-pdfKey=$S3_PFD_KEY aws-accesskey=$AWS_ACCESS_KEY aws-secretkey=$AWS_SECRET_KEY"
   ```
