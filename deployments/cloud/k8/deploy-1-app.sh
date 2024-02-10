
kubectl create namespace account-balance-service-single
kubectl config set-context --current --namespace=account-balance-service-single
kubectl apply -f deployments/cloud/k8/app/account-balance-service/account-balance-service.yaml