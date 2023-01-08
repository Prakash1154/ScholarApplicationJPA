pipeline{
  agent any
    stages{
      stage('Git Checkout'){
        steps{
          git branch: 'main', url: 'https://github.com/Prakash1154/ScholarApplicationJPA.git'
        }
      }
      stage('Maven Build'){
        steps{
          withMaven(maven: 'mvn') {
                sh "mvn clean install"
            }
        }
      }
    }
}