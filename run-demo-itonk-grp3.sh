#Setup kubectl to the correct cluster
kubectl config set-cluster cluster71 --server=http://192.168.1.71:8080
kubectl config set-context cluster71 --cluster=cluster71
kubectl config use-context cluster71

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

echo '-> Starting Product-service...'
kubectl create -f kubernetes-yaml/product-service-deployment.yaml
kubectl create -f kubernetes-yaml/product-service-svc.yaml

sleep 20s
echo '<- Product-service started'


echo '-> Starting Order-service...'
kubectl create -f kubernetes-yaml/order-service-deployment.yaml
kubectl create -f kubernetes-yaml/order-service-svc.yaml

sleep 20s
echo '<- Order-service started'


echo '-> Starting Web-service...'
kubectl create -f kubernetes-yaml/web-service-deployment.yaml
kubectl create -f kubernetes-yaml/web-service-svc.yaml

sleep 20s
echo '<- Web-service started'


echo '-> Starting Website...'
kubectl create -f kubernetes-yaml/website-deployment.yaml
kubectl create -f kubernetes-yaml/website-svc.yaml

sleep 20s
echo '<- Website started'


