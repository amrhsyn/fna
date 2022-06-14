
#  Description

A sample project contains a list and map .

#  Stack :
- Kotlin
- Compose + Flow
- Coroutines
- Clean architecture + MVVM
- Multi module (feautred-layerd-base)
- Retrofit + Gson
- Google maps
- Junit
- Mockk
- Mockwebserver

#  Screenshots

<img src="https://github.com/amrhsyn/free-now-assignment/blob/main/screenshots/s1.png" width="25%">
<img src="https://github.com/amrhsyn/free-now-assignment/blob/main/screenshots/s2.png" width="25%">

#  Module Design

| Module name | Description |

| ------------- | ------------- |

| [app](/app/) | main activity, application class, navigation, and tests |

| [core](/core/)  | core business models and util classes. |

| [core_ui](/core_ui/)  | core ui utils classes. |

| [fleetlist presentation](/fleetlist/fleetlist_presentation/)  | fleet list ui contains compose files, viewmodels and etc ... |

| [fleetlist domain](/fleetlist/fleetlist_domain) | fleet list domain layer contains repository interfaces and usecases calasses |

| [fleetlist data ](/fleetlist/fleetlist_data/) | fleet list data layer contains repositories implementation, retrofit, dto files, mappers |

| [fleetmap presentation ](/fleetmap/presentation/)  | fleet map ui contains compose files, viewmodels and etc .... |

#  Architecture
- I used MVVM + Clean Architecture, I have three separated modules named presentation, domain, data for each feature module, with this I have strict separation in my layers and they don't access each other I implemented all clean architecture concepts because the project was for testing and I think it's over-engineering for this project.

#  And 
- There are some test in the [fleetlist data ](/fleetlist/fleetlist_data/) test directory and [app](/app/) androidTest directory.
- I used Hilt as my DI library because I think Hilt has fewer boilerplate codes than dagger2 but I could use dagger2 or even koin too.
- I used Coroutines and Flows for app threading and observing because it's lighter than Rx, it's native and integrated with other google libraries and it's easier to test because google has some libraries for testing them.
- For better performance, I wanted to have pagination in my app but the endpoint does not support that
- For UI/UX, I tried to keep it simple, I used material design and free assets(cars images) 
- I used git-flow as my git strategy, I created main, develop, feature/fleet_list, and feature/fleet_map branches