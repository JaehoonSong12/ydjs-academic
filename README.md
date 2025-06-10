<!-- 
 @requires
 1. VSCode extension: Markdown Preview Enhanced
 2. Shortcut: 'Ctrl' + 'Shift' + 'V'
 3. Split: Drag to right (->)

 @requires
 1. VSCode extension: Markdown All in One
 2. `File` > `Preferences` > `Keyboard Shortcuts`
 3. toggle code span > `Ctrl + '`
 4. toggle code block > `Ctrl + Shift + '`

 @usage
 1. End of Proof (Q.E.D.): <div style="text-align: right;">&#11035;</div>
 2. End of Each Section: 

     <br /><br /><br />

     ---



     <p align="right">(<a href="#readme-top">back to top</a>)</p>
     

 3. ![image_title_](images/imagefile.png)
 4. [url_title](URL)
 -->
<!-- Anchor Tag (Object) for "back to top" -->
<a id="readme-top"></a> 



# Project Repo by YDJS (Jaehoon Song) Academic
Welcome to the YDJS project repository! This repo is for my students to study computer basics, AP CS principle, GT CS1301 (CS A), and GT CS1331: Object-Oriented Programming. Also, this README provides quick access to project documentation and code.



## Table of Contents
- [Project Repo by YDJS (Jaehoon Song) Academic](#project-repo-by-ydjs-jaehoon-song-academic)
  - [Table of Contents](#table-of-contents)
- [Project Overview](#project-overview)
  - [Documentation](#documentation)
  - [Code Access](#code-access)
  - [Contributing](#contributing)
- [Instructions](#instructions)
  - [Git/GitHub Script Interaction](#gitgithub-script-interaction)
  - [Git/GitHub Manual Interaction](#gitgithub-manual-interaction)
  - [Python (GT CS 1301 / AP CS A)](#python-gt-cs-1301--ap-cs-a)













<br /><br /><br />

---

# Project Overview
This project is designed to support students studying AP subjects, specifically 
1. AP CS Principles - **JavaScript**
2. GT CS 1301: Intro to Computing (CS A) - **Python**
3. GT CS 1331: Introduction to Object-Oriented Programming (CS A). - **Java**


## Documentation

For detailed documentation, including textbook references, project specifications, development guidelines, and usage instructions, please visit our documentation on Google Drive:

[YDJS Academy Documentation](https://drive.google.com/drive/folders/1quzaFGCofImVVMIplGbBr-Biqa3eWYgq?usp=drive_link)

## Code Access

The code for this project is hosted on GitHub in this repository. You can explore the source code, contribute, and access different branches as necessary:

[GitHub Repository - YDJS Academy Project](https://github.com/JaehoonSong12/ydjs_academic)

## Contributing

We welcome contributions! If you would like to suggest improvements, please submit a pull request, or open an issue.


<p align="right">(<a href="#readme-top">back to top</a>)</p>










<br /><br /><br />

---

# Instructions
Here are the steps to initiate your project.

## Git/GitHub Script Interaction
All the students are expected to have git scripts (e.g. `git00-...`, `git01-...`, `git03-...`) for version control. 
1. Open up your IDE in the project directory.
2. Type in `../`, then double tab.
3. `./git00-init`: to initialize your project repository. Once you initialize, `cd <your_directory>`.
4. `../git00-init`: not expected to do anything inside the repo.
5. `../git01-pull.sh`: to pull all the changes upto date **before everytime you start working**.
6. `../git03-branch+push.sh <branch_name> [commit_message]`: to push all the changes and make PR in GitHub, [GitHub Repository - YDJS Academy Project](https://github.com/JaehoonSong12/ydjs_academic), **after everytime you finish working**.
7. If, you do not see the scripts, reach out to the instructor (Jaehoon Song, manual20151276@gmail.com) to get the scripts to start off.



## Git/GitHub Manual Interaction
To start, clone the repository using the following command:
```bash
git clone https://github.com/JaehoonSong12/ydjs_academic.git
cd ydjs_academic
```

## Python (GT CS 1301 / AP CS A)
After cloning, initialize the repository by running the provided bash scripts (`copy`, then `right-click` in a bash session):
1. Run the initial setup script (to download **Python Language System**):
   ```bash
   ./scripts/python01-init.sh
   ```
2. Run the project setup script (to configure **Virtual Environment** in `src` subdirectory):
   ```bash
   ./scripts/python02-config.sh
   ```


<p align="right">(<a href="#readme-top">back to top</a>)</p>
