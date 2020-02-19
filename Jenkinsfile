node{

    stage('SCM Checkout'){
        git credentialsId: 'GIT_CREDENTIALS', url:  'https://github.com/Steven8519/developer-service.git', branch: 'master'
    }

    stage("Gradle build"){
      sh "./gradlew clean build"

    }


    stage('Build Docker Image'){
        sh 'docker build -t steven8519/developer-service .'
    }

    stage('Push Docker Image'){
        withCredentials([string(credentialsId: 'Docker_Hub_ID', variable: 'Docker_Hub_ID')]) {
          sh "docker login -u steven8519 -p ${Docker_Hub_ID}"
        }
        sh 'docker push steven8519/developer-service'
     }

     stage("Deploy MongoDB"){
      kubernetesDeploy(
         kubeconfigId: 'kubeconfig',
         configs: 'mongodb.yaml',
         enableConfigSubstitution: true
      )
    }

      stage("Deploy app"){
        kubernetesDeploy(
            kubeconfigId: 'kubeconfig',
            configs: 'deployment.yaml',
            enableConfigSubstitution: true
        )
      }

      stage("Deploy app"){
              kubernetesDeploy(
                  kubeconfigId: 'kubeconfig',
                  configs: 'istio-gateway.yaml',
                  enableConfigSubstitution: true
              )
            }

}