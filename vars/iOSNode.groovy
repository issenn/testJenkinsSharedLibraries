#!/usr/bin/env groovy

def call(Map parameters = [:], Closure body={}) {

    def defaultLabel = buildId('iOS')
    echo defaultLabel
    // def label = parameters.get('label', defaultLabel)

    pipeline {
        agent none

        stages {
            stage('Test') {
                agent {
                    node {
                        label 'master'
                        customWorkspace "workspace/${JOB_NAME.replace('%2F', '/')}"
                    }
                }
                when {
                    beforeAgent true
                    branch "master"
                }
                steps {
                    sh "echo test."
                }
            }
        }
    }
}