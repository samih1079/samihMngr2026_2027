# MVVM Architecture Analysis & Implementation Report

## Project Analysis (Before)
- **Model**: Room Database (`AppDataBase`), Entities (`MyUser`, `MyTask`), DAOs (`MyUserQuery`, `MyTaskQuery`).
- **View**: Activities (`MainActivity`, `AddTaskActivity`, `RegisterActivity`) interacting directly with the Room database (`AppDataBase.getDb(...)`).
- **ViewModel / Repository**: Missing. Business logic and data operations were tightly coupled inside the Activities.

## Implemented Architecture (MVVM)

To achieve a clean MVVM (Model-View-ViewModel) architecture:

1. **Repository Layer (`repository/`)**:
   - `TaskRepository`: Encapsulates operations for tasks (`MyTaskQuery`).
   - `UserRepository`: Encapsulates operations for users (`MyUserQuery`).

2. **ViewModel Layer (`viewmodel/`)**:
   - `TaskViewModel`: Extends `AndroidViewModel`, providing task data (`LiveData`) and insertion methods to the View.
   - `UserViewModel`: Extends `AndroidViewModel`, handling user authentication/registration checks (`getUserByEmail`, `login`, `insert`) for the View.

3. **View Layer (`ViewPkg/`)**:
   - `AddTaskActivity`: Refactored to obtain `TaskViewModel` via `ViewModelProvider` and delegate task insertion to the ViewModel.
   - `RegisterActivity`: Refactored to obtain `UserViewModel` via `ViewModelProvider` and delegate user checks/registration to the ViewModel.

## Verification
- Built successfully using `gradle_build` (`app:assembleDebug`).
