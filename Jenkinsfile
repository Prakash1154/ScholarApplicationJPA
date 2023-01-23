import groovy.json.JsonSlurperClassic
def devClusterName = 'devfarm.cobalt.ariba.com'
def serviceContext = '-'
pipeline{

  agent any
   stages{
      stage('Git Checkout'){
        steps{
        script{
//        git branch: 'main', url: 'https://github.com/Prakash1154/ScholarApplicationJPA.git'
//        println("Health check started")
//        url = ' "https://' + devClusterName + '/search'+serviceContext+'publish/v1/service/health" '
//        getCall = new URL(url).openConnection()
//        println("Health check url done")
//        getCallRC = getCall.getResponseCode()
//        println("Health check url response code")
//        println(getCallRC)
//        if(getCallRC.equals(200)) {
//         println("inside if condition")
//         println(getCall.getInputStream().getText())
//         }

          calendar_url = "https://devfarm.cobalt.ariba.com/search-publish/v1/service/health"
          curl_output = sh returnStdout: true, script: "curl -s ${calendar_url}"
          //sh returnStdout: true, script: "curl -s ${calendar_url}",,,,
          //sh(script: "curl -s ${calendar_url}) it means execute the script and it will return null
          // if we make returnStdout: true it means response will be store in curl_output,
          println curl_output
          data = new JsonSlurperClassic().parseText(curl_output)
          println data.status
          if(data.status.toString().equals("UP")){
            println 'inside if'
            stage('stage inside if'){
                    sh 'mvn clean install'
                }
          }
          else{
             error("Error while calling Health check API, Health check status is " + data.status.toString())
          }
      }
    }
  }
  stage('Git stage test'){
          sh 'mvn clean install'
           }
 }

}