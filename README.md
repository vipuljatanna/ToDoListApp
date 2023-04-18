
# Key Points

- [MVC](#mvc)
- [Multi Platform](#multi-platform)

<a name="mvc"></a>
## 1. MVC
The entire framework is based on the MVC (Model-View-Controller) architecture.
The three parts of the MVC software-design pattern can be described as follows -
  ##### 1. Modal: Manages data and business logic.

  ##### 2. View: Handles layout and display.

  ##### 3. Controller: Routes commands to the model and view parts.

In our framework, we are using Redux. Redux helps in state management by storing all the states which need to be changed throughout the app in one place.


The Redux Store (Model) would keep a small portion of the business logic, while the Reducer (Controller) is responsible for handling the input from the User and converting it into method calls against the Model. Our React Component (View) would observe these changes, and reflect the UI accordingly.

<a name="multi-platform"></a>
## 2. Multi platform

We’re using the library react-native-web which is a compatibility layer between React DOM and React Native, because of which our code for native app can run on Web browser too!


### Directory structure details -

- `indexNative.js` - Entry file for Native app.
- `indexWeb.js` - Entry file for Web app.

- `loader.js` - It’s executed in indexNative or indexWeb. Loads libraries and configurations like theme, core functions and Environment Configurations.

- `root.js`- It’s executed in indexNative or indexWeb. It returns a React Component, wrapped with different Provider React components to pass data through the component tree (without having to pass props down manually at every level).

- `app.js` - This is executed in root.js. Loads the navigator from apps folder based on platform, and initializes all required hooks ( Ex: useToast, useSelector, useDispatch ) in the global Lib variable. (Here the variable Lib is passed to each file as parameter)
- `apps` - This can contain more than 1 app. Each folder will have the same file structure as mentioned in point 8, with the difference that the app here may have only limited screens - like splash or landing screens. (confirm from Shiv)
- `core_ui` - Contains getter and setter functions which can be specific to a module (business logic) or common functions which can be used in multiple modules of our project.
For example, if we need a customer's name in multiple places of our app, we can have a getter function in our customer module to get the customer’s name. This way, if in future the key for the customer's name is changed in the database, it can be changed in just one function in our Core-UI.
- `modules` - Our application is divided into multiple modules. Each module has files mentioned below -
   - `index.js` - Entry file. Initialize navigator based on platform.
   - `modals.js` - Load all the Modals in the global Lib variable.
   - `modal`  - React Component(s). The children of a Modal will always be a partial.
   - `size`  - Contains large, small and responsive folders. And both large and small folders will have screens and navigation folders.
   
      - `small` - Contains Screens and Navigator for Mobile.
      - `large` -  Contains Screens and Navigator for Tablet or Web Browser.
      - `responsive` - Contains Partials (Check point 9)

- `partials` - React Components. Possible use cases - 
    - `Decoupling in Modals` - Modals’ outer container and its children are separated. Here Partial is the children of the Modal. This also applies for screens.
    - `Code reusability` - When there is a complex piece of code which may involve business logic and might be used in more than one screen, it can be made as a Partial.

- `redux` -
    - `reducerIndex` -  Combines all reducers
    - `reducerStore` -  Creates a Redux store that holds the complete state tree of your app.
    - `dispatcherIndex` -   Returns all dispatch functions to dispatch actions as needed.
    - `selectorIndex` -  Returns all selector functions. Allows you to extract data from the Redux store state.
    - `reduxPersistedStore` - Saves the application's Redux state object to Local-Storage.
    - `modules` - Each module has the below file structure.
    - `dispatcher` -  Contains dispatch (setter) functions
    - `selector` -  Contains selector (getter) functions
    - `reducer` - This is the main Controller of Redux. Contains functions which will update the global state based on Action provided.

