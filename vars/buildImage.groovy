def call(String imagename) {
    echo 'building docker image'
    withCredentials([
        usernamePassword(
            credentialsId: 'dockerhub-creds',
            usernameVariable: 'USERNAME',
            passwordVariable: 'PASSWORD'
        )
    ]) {
        // sh 'docker build -t dukaegbu/dbase-repo:myapp-2.0 .'
        sh "docker build -t $imagename ."
        sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
        // sh 'docker push dukaegbu/dbase-repo:myapp-2.0'
        sh "docker push $imagename"
    }
}
