def call() {
    echo 'building docker image'
    withCredentials([
        usernamePassword(
            credentialsId: 'dockerhub-creds',
            usernameVariable: 'USERNAME',
            passwordVariable: 'PASSWORD'
        )
    ]) {
        sh 'docker build -t dukaegbu/dbase-repo:myapp-2.0 .'
        sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
        sh 'docker push dukaegbu/dbase-repo:myapp-2.0'
    }
}
