def devClusterName = 'devfarm.cobalt.ariba.com'
def serviceContext = '-'
def getCall = ''
def getCallRC = ''
def url=''
def yourURLStr = ''
pipeline{

  agent any
   stages{
      stage('Git Checkout'){
        steps{
        script{
       git branch: 'main', url: 'https://github.com/Prakash1154/ScholarApplicationJPA.git'
       println("Health check started")
       url = ' "https://' + devClusterName + '/search'+serviceContext+'publish/v1/service/health" '
       getCall = new URL(url).openConnection()
       println("Health check url done")
       getCallRC = getCall.getResponseCode()
       println("Health check url response code")
       println(getCallRC)
       if(getCallRC.equals(200)) {
        println("inside if condition")
        println(getCall.getInputStream().getText())
        }
        }
        }
        }
   }
   }