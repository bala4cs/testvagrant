# testvargant

To execute the scripts in intelliJ

Use the command in your terminal : 

        mvn clean install 



**Setup In Jenkins**

**Getting Started with Cucumber Jenkins Setup**
Cucumber is well-known for agile development of web applications and reporting the results. With an easy-to-understand language, powerful plugins, and a straightforward integration with Selenium, starting Cucumber with Jenkins integration has never been easier.

Now, let us see how to integrate Cucumber with Jenkins.

**Prerequisites for Cucumber with Jenkins Integration**

We need the installation of the below plugins to start Cucumber with Jenkins integration. Let us see an overview and utilities of the below plugins. This section will see how to make use of some Jenkins plugins that work together with Cucumber formatting outputs.

    Cucumber Test Results plugin
    Cucumber Reports

**A. Cucumber Test Results plugin**
This plugin takes Cucumber JSON output as input and publishes the results in polychrome. The results will appear in GREEN when they have passed and RED when they fail.

Here’s how to install the Cucumber Test Results plugin.

1. Login to your Jenkins server as an administrator.
2. Navigate to “Manage Jenkins.”
3. Go ahead and click “Manage Plugins.” Manage Plugins 
4. Go to the “Available” tab under the manage plugins page. 
5. Search for “cucumber” in the filter at the right top corner. 
6. Go ahead and check the box against the Cucumber reports. 
7. Choose “Install without restart” to start the installation. 
8. Click “Back to dashboard” in the left menu 
9. Navigate to the job already created. ‘Cucumber’ in our case. 
10. Click “Configure” against the job. 
11. Scroll down to Post-Build Actions. Under “Add post-build action,” select “ Cucumber reports.” 
12. Click on Advanced. Go to Post-build Actions. Add below report file in the text box as shown. You can Ignore the message at the bottom. It appears since we don’t have any files yet, once we run the build, they will be created. 
13. The next step is to generate Cucumber JSON reports. 
14. Open the cucumber.yml file in your page-object_framework and add the below-highlighted string. 
15. This is to make sure we have reports.json output in addition to the HTML reports. The cucumber plugin will parse these on Jenkins.
cucumber_yml_json


**Execution**

To execute, click the “Build Now” button from the left menu for the job. The build should be successful. Instead of watching console output, select “Cucumber Test Result” at the end of the build.


**Results**

Next, go to **Feature –> Scenario**, where you can see all the steps’ status. As shown below, they are all GREEN.

**B. Cucumber Reports**
Cucumber Reports plugin can read the JSON output and produce pie charts for feature or scenario results & bar graphs for tags. This is possible if we had options “-f json -out cucumber.json,” where you output the results to JSON format, i.e., in cucumber.yml. This plugin has advanced options to help us make vital decisions on the test results.

1. Add a post-build step and select the “Publish cucumber results as a report” option, as shown below.
2. Referring to the job, the below menu option will be visible to us as below.
3. Next, run the job and click the reports. The reports will be in the form of SWF charts, as shown below.