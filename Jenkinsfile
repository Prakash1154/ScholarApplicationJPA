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
                  sh 'mvn test'
              }
            }
      stage('Maven Build'){
        steps{
            sh 'mvn clean install'
        }
      }
    }
}