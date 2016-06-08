FROM resin/rpi-raspbian

RUN apt-get update
RUN apt-get install -y wget dialog

RUN wget http://node-arm.herokuapp.com/node_latest_armhf.deb
RUN dpkg -i node_latest_armhf.deb

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY package.json /usr/src/app/
RUN npm install --production
COPY dist/ /usr/src/app/dist/
COPY server.js /usr/src/app/

EXPOSE 8080

CMD ["node", "server.js"]
