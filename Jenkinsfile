def devClusterName = 'devfarm.cobalt.ariba.com'
def serviceContext = '-'
def getCall = ''
def getCallRC = ''
def url=''
def String yourURLStr = ''
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
              url = ' "https://' + devClusterName + '/search'+serviceContext+'publish/v1/service/health" '
//              getCall = new URL(' "https://' + java.net.URLEncoder.encode(devClusterName, "UTF-8") + '/search'+java.net.URLEncoder.encode(serviceContext, "UTF-8")+'publish/v1/service/health" ')
              yourURLStr = java.net.URLEncoder.encode(url, "UTF-8");

// String url = "http://e2e-soaservices:44000/3.1/StandardDocumentService?wsdl";
// String yourURLStr = java.net.URLEncoder.encode(url, "UTF-8");
              java.net.URL getCall = new java.net.URL(yourURLStr);

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
