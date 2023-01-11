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

      stage('Maven test'){
              steps{
              println("in jenkins")
              //https://devfarm.cobalt.ariba.com/search-publish/v1/service/health

              getCall = new URL(' "https://' + devClusterName + '/search'+serviceContext+'publish/v1/service/health" ')
              getCallRC = getCall.getResponseCode()
              println(getCallRC)
              if(getCallRC.equals(200)) {
              println(getCall.getInputStream().getText())
                  sh 'mvn test'
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