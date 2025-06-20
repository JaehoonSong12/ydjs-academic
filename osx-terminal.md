# ZSH Shell Guide

## 1. What Is a Shell? Why zsh?

1. **Definition**  
   - The shell is your bridge to the operating system’s core (the kernel). It interprets text commands into system calls.  
   - Think of it like a chatbot you talk to, except your “messages” are commands, and it responds by running tasks (listing files, launching programs, copying data, etc.).

2. **zsh vs. Other Shells**  
   - **bash** (Bourne‐Again SHell): Used to be macOS’s default until Catalina.  
   - **zsh** (Z Shell):—A superset of bash; all bash scripts generally work in zsh but with extra features.  
     - **Tab‐completion**: More intelligent—predicts commands, file names, flags, even hostnames.  
     - **Prompt customization**: With themes (e.g., [Oh My Zsh](https://ohmyz.sh)) you can have colorful prompts showing Git branch, exit codes, etc.  
     - **Globbing**: Extended pattern matching (e.g., `**/*.txt` to find all `.txt` files recursively).  
     - **Scripting improvements**: Better array handling, additional built‐ins.

3. **Opening zsh on macOS**  
   - Launch **Terminal** (Applications → Utilities → Terminal).  
   - By default, you should see something like:
     ```
     your‐macbook:~ yourname% 
     ```
     That `%` (or sometimes `$`) is the zsh prompt. If you ever see something like `bash-3.2$`, you can type:
     ```shell
     zsh
     ```
     to switch into zsh (although on modern macOS, zsh is already default).

## 2. Your First Steps: Navigating the Filesystem

All commands follow the general pattern:
```
command [options] [arguments]
```

1. **`pwd` – Print Working Directory**  
   ```shell
   % pwd
   /Users/yourname
   ```

2. **`ls` – List Files and Directories**  
   ```shell
   % ls
   Desktop   Documents   Downloads   Pictures
   % ls -l
   % ls -a
   % ls -la
   ```

3. **`cd` – Change Directory**  
   ```shell
   % cd Documents
   % cd ..
   % cd
   % cd ~/Desktop
   ```

4. **`mkdir` – Make Directory**  
   ```shell
   % mkdir project_folder
   ```

5. **`rmdir` – Remove (Empty) Directory**  
   ```shell
   % rmdir old_folder
   % rm -r non_empty_folder
   ```

## 3. Working with Files

1. **`touch`**  
   ```shell
   % touch notes.txt
   ```

2. **`cp`**  
   ```shell
   % cp notes.txt backup_notes.txt
   % cp -r project_folder project_folder_backup
   ```

3. **`mv`**  
   ```shell
   % mv notes.txt ideas.txt
   % mv ideas.txt project_folder/
   % mv project_folder project_archive
   ```

4. **`rm`**  
   ```shell
   % rm ideas.txt
   % rm -r project_archive
   % rm -rf some_dir
   ```

5. **Viewing File Contents**  
   ```shell
   % cat notes.txt
   % less bigfile.log
   % head notes.txt
   % tail error.log
   ```

## 4. Searching and Pattern Matching

1. **`grep`**  
   ```shell
   % grep "TODO" notes.txt
   % grep -i "error" server.log
   % grep -rn "function_name" .
   ```

2. **`find`**  
   ```shell
   % find . -type f -name "*.txt"
   % find /Users/yourname -type d -name "backup"
   ```

3. **Globbing (zsh’s Extended Patterns)**  
   ```shell
   % ls *.txt
   % ls file[0-9].log
   % ls **/*.md
   ```

## 5. Redirection & Piping

1. **`>` and `>>`**  
   ```shell
   % echo "Hello, world!" > hello.txt
   % echo "Second line" >> hello.txt
   ```

2. **Pipes (`|`)**  
   ```shell
   % ls -l | grep "^d"
   % cat server.log | grep "ERROR" | less
   ```

3. **Standard Error Redirection (`2>`)**  
   ```shell
   % ls nonexistentfile 2> errors.txt
   ```

## 6. Environment Variables & Customization

1. **Environment Variables**  
   ```shell
   % echo $PATH
   % export EDITOR="vim"
   ```

2. **Aliases**  
   ```shell
   alias ll="ls -lah"
   alias gs="git status"
   source ~/.zshrc
   ```

3. **`~/.zshrc`**  
   ```shell
   % nano ~/.zshrc
   % source ~/.zshrc
   ```

## 7. Getting Help

1. **`man`**  
   ```shell
   % man ls
   ```

2. **`--help` or `-h`**  
   ```shell
   % ls --help
   % grep --help
   ```

3. **`apropos` / `whatis`**  
   ```shell
   % whatis ls
   % apropos network
   ```

## 8. Some Useful Built‐In zsh Features

1. **Command History**  
   ```shell
   % history
   % !23
   ```

2. **Globbing (Advanced)**  
   ```shell
   % ls **/*.jpg
   % ls ^(*.mp3)
   ```

3. **Auto‐correction / Auto‐suggestions**

4. **Globbing Qualifiers**  
   ```shell
   % ls *(.)
   % ls *(.om[1m])
   ```

## 9. Sample Workflow / Practice Exercises

1. **Create a Project Folder**  
   ```shell
   cd ~/Desktop
   mkdir my_zsh_practice
   cd my_zsh_practice
   ```

2. **Create Files & Explore**  
   ```shell
   touch file1.txt file2.txt notes.md
   ls -l
   ```

3. **Move/Rename & Copy**  
   ```shell
   mv file1.txt document1.txt
   cp document1.txt document1_backup.txt
   ls
   ```

4. **Use `grep` to Search**  
   ```shell
   echo "Hello zsh
Practice makes perfect" > notes.md
   grep "zsh" notes.md
   ```

5. **Use Piping + Redirection**  
   ```shell
   ls -l | grep ".txt" > txt_files_list.txt
   cat txt_files_list.txt
   ```

6. **Experiment with `find`**  
   ```shell
   find . -type f -name "*.md"
   ```

7. **Play with Aliases**  
   ```shell
   nano ~/.zshrc
   alias zs="cd ~/Desktop/my_zsh_practice"
   alias ll="ls -lah"
   source ~/.zshrc
   zs
   ll
   ```

## 10. Summary of Common Commands

| Command     | Purpose                                                    | Example                                                      |
|-------------|------------------------------------------------------------|--------------------------------------------------------------|
| `pwd`       | Show current directory                                     | `pwd` → `/Users/yourname`                                    |
| `ls`        | List files/directories                                      | `ls -lah` → long listing including hidden                     |
| `cd`        | Change directory                                           | `cd Documents/projects`                                      |
| `mkdir`     | Create a new directory                                     | `mkdir new_folder`                                           |
| `rmdir`     | Remove an empty directory                                   | `rmdir old_folder`                                           |
| `touch`     | Create empty file / update timestamp                       | `touch notes.txt`                                            |
| `cp`        | Copy files/directories                                      | `cp file1.txt file1_backup.txt`                              |
| `mv`        | Move/rename files or directories                            | `mv file1.txt archive/`                                      |
| `rm`        | Remove files/directories                                    | `rm unwanted.txt` / `rm -r old_folder`                        |
| `cat`       | Display file contents                                      | `cat notes.txt`                                              |
| `less`      | View a file one page at a time                              | `less bigfile.log` (Exit with `q`)                            |
| `grep`      | Search inside files for patterns                            | `grep "TODO" notes.md`                                       |
| `find`      | Find files/directories by name, type, size, etc.            | `find . -type f -name "*.txt"`                               |
| `echo`      | Print arguments (often used with redirection)                | `echo "Hello" > hello.txt`                                   |
| `>`, `>>`   | Redirect output to a file (overwrite / append)              | `ls > listing.txt`, `echo "more" >> listing.txt`             |
| `|`         | Pipe output of one command into another                      | `cat file.txt \| grep "error"`                                |
| `man`       | Show manual page for a command                               | `man ls`                                                     |
| `alias`     | Create shortcuts for commands                                | `alias ll="ls -lah"`                                          |
| `source`    | Reload a startup file (e.g., `~/.zshrc`)                      | `source ~/.zshrc`                                            |

---

### Next Steps

1. **Experiment daily**: Try to do simple file‐management tasks entirely in the terminal (without Finder).  
2. **Customize your prompt**: Consider installing [Oh My Zsh](https://ohmyz.sh/) to get themes, plugins, and auto‐suggestions.  
3. **Write simple shell scripts**: Create a file called `backup.sh`:
   ```shell
   #!/usr/bin/env zsh
   # Simple backup script
   src="$HOME/Documents"
   dest="$HOME/Desktop/Documents_backup_$(date +%Y%m%d)"
   cp -r "$src" "$dest"
   echo "Backed up Documents to $dest"
   ```
   Make it executable and run:
   ```shell
   chmod +x backup.sh
   ./backup.sh
   ```

4. **Learn more built‐ins**: zsh has many built‐in commands—`autoload`, `pushd`/`popd`, `setopt`, etc.—but mastering the basics first will get you through 90% of day‐to‐day tasks.

By practicing these commands and gradually customizing your zsh environment (aliases, prompt, plugins), you’ll build muscle memory. The more you type `cd ~/projects` instead of “double‐clicking” in Finder, the more comfortable you’ll get. Happy shelling!
