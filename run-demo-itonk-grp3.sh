# create Config-server
kubectl create -f kubernetes-yaml/config-service-deployment.yaml
kubectl create -f kubernetes-yaml/config-service-svc.yaml

echo '-> Waiting for configuration server to start-up'

sleep 100s

echo '<- Configuration server started'

echo '-> Starting API Gateway...'
kubectl create -f kubernetes-yaml/gateway-service-deployment.yaml
kubectl create -f kubernetes-yaml/gateway-service-svc.yaml

sleep 20s
echo '<- API Gateway started'



