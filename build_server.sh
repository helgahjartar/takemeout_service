# Build server

echo "Building takemeout service ..."

cd registered_event_service

gradle wrap

./gradlew build
