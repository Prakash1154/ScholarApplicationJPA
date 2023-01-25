import groovy.json.JsonSlurperClassic
def devClusterName = 'devfarm.cobalt.ariba.com'
def serviceContext = '-'
def Ur = env.BUILD_URL
def BN = env.BUILD_NUMBER

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

        nomadUrl = "http://devfarm-ncv.cobalt.ariba.com:4646/v1/jobs"
        result = sh returnStdout: true, script: "curl -s ${nomadUrl}"
                      //sh(script: "curl -s ${url}) it will execute the script and will return null by default
                      // if we make returnStdout: true, it means result will be store in variable response,
        jobs = new JsonSlurperClassic().parseText(result)
        println jobs[0]
        r = env.BUILD_TAG
        println r
        println r
        jobs.removeAll {it.Status == "dead"}
        allJobs = jobs.getAt("ID")
        println allJobs
        println BN
        for(id in allJobs){
            id1=id
            arr = id.toString().tokenize( '-' )
            println arr
            println arr.size()
            println arr[4]
            if(arr.size() > 4){
              if(arr[4] == 8){
                myJob = id1
                break
              }
            }
        }
        println r
        println myJob
//         sp = myJob.tokenize( '-' )
//         println Ur
//         println sp
        println BN
        ca = 'https://ci.cobalt.only.sap/job/ariba-search/job/typeService/job/CAR-16569-Health_Check/8/api/json'
        res = sh returnStdout: true, script: "curl -s ${ca}"
        println res
        //jo = new JsonSlurperClassic().parseText(res)
        ids = new groovy.json.JsonSlurper().parseText( res )
        println ids
        //println jo.getAt("displayName")

m=env.JOB_BASE_NAME
println m

          parameters = Jenkins.instance.getAllItems(env.JOB_BASE_NAME).getAction(hudson.model.ParametersAction)
          println 'parameter'
          println parameters.getParameter('SOME_PARAMETER').value


          build = Thread.currentThread().toString()
          println build
          regexp= ".+?/job/([^/]+)/.*"
          match = build  =~ regexp
          println match
          jobName = match[0][1]
          println jobName

          calendar_url = "https://devfarm.cobalt.ariba.com/search-publish/v1/service/health"
          curl_output = sh returnStdout: true, script: "curl -s ${calendar_url}"
          //sh returnStdout: true, script: "curl -s ${calendar_url}",,,,
          //sh(script: "curl -s ${calendar_url}) it means execute the script and it will return null
          // if we make returnStdout: true it means response will be store in curl_output,
          println curl_output
          data = new JsonSlurperClassic().parseText(curl_output)
          println data.status
          if(data.status.toString().equals("P")){
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
           steps{println 'stage testing'}
           }
 }

}