# Collab Buddy Mobile App
## Extension to the Web Application
### Web App: https://github.com/Anniegavr/Collab-Buddy

### Features
- Authentication with email and password
- Navigation drawer
- Posts by Interests
- Home page featuring posts
- Bookmark save post
- Add posts to interests
- Add people to network
- Switch to dark mode

### Tech-related features
- <ins>Authentication</ins>:  OkHttp authentication token on the device using SharedPreferences.
- <ins>Network</ins> Operations:  connects to my backend RESTful API to fetch news articles. It performs network operations outside the UI thread and uses a NetworkAvailabilityTracker to check the device network connection and respond to changes.
- <ins>Caching</ins>: uses an in-memory cache to store the data retrieved from the network. You could modify it to use SharedPreferences or DataSource to persist the cached data.
- <ins>UI</ins>:  uses Material3 Design components throughout the app, so it already satisfies this requirement.
