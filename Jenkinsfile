import groovy.json.JsonSlurperClassic
def devClusterName = 'devfarm.cobalt.ariba.com'
def serviceContext = '-'
def getCall = ''
def getCallRC = ''
def calendar_url
def yourURLStr = ''
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
def curl_output = sh returnStdout: true, script: "curl -s ${calendar_url}"
//sh returnStdout: true, script: "curl -s ${calendar_url}",,,,
//sh(script: "curl -s ${calendar_url}) it means execute the script and it will return null
// if we make returnStdout: true it means response will be store in curl_output,
println curl_output
// def holidays = readJson text: curl_output
// println holidays
// println curl_output.response
def data = new JsonSlurperClassic().parseText(curl_output)
println data.status
if(data.status == 'P'){
println 'inside if'
stage(' stage inside if'){
        steps{}
}
}
else{
println 'Error while calling Health check API'
}
        }
        }
        }
   }
   }