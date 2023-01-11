def devClusterName = 'devfarm.cobalt.ariba.com'
def serviceContext = '-'
def getCall = ''
def getCallRC = ''
pipeline{

  agent any
   stages{
      stage('Git Checkout'){
        steps{
          git branch: 'main', url: 'https://github.com/Prakash1154/ScholarApplicationJPA.git'
        }
      }
// String paramValue = "param\\with\\backslash";
// String yourURLStr = "http://host.com?param=" + java.net.URLEncoder.encode(paramValue, "UTF-8");
// java.net.URL url = new java.net.URL(yourURLStr);
      stage('Maven test'){
              steps{
              println("in jenkins")
              //https://devfarm.cobalt.ariba.com/search-publish/v1/service/health
              script{
//getCall = new URL(' "https://' + devClusterName + '/search'+serviceContext+'publish/v1/service/health" ')
              getCall = new URL(' "https://' + java.net.URLEncoder.encode(devClusterName, "UTF-8") + '/search'+java.net.URLEncoder.encode(serviceContext, "UTF-8")+'publish/v1/service/health" ')
              getCallRC = getCall.getResponseCode()
              println(getCallRC)
              if(getCallRC.equals(200)) {
              println(getCall.getInputStream().getText())
                  sh 'mvn test'
              }
              }
            }
      }
      stage('Maven Build'){
        steps{
            sh 'mvn clean install'
        }
      }
    }
}
