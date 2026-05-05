package JavaOopsAndCollection;

public class GitTest {
/*
1. Describe the steps you would use to initialize a new Git repository and make your first commit of a file named "test.txt" with the content "Hello, Git!".
git init
echo "Hello, Git!" > test.txt
git add test.txt
git commit -m "Initial commit"

2. You’ve modified several files in your local working directory. Explain the command(s) you would use to view which files have been modified and see the detailed commit history.
git status          # modified files
git diff            # changes
git log             # full history
git log --oneline --graph --all

3. Clone Repository
git clone <repo-url>
cd <repo-name>

4. Branch Workflow
git checkout -b feature-login
git add .
git commit -m "Add login feature"
git status

5. Merge Branch
git checkout master
git merge feature-navbar

6. Explain the process of rebasing your feature branch onto the updated `master` branch. What considerations should you take into account while deciding between merging and rebasing?

git checkout feature-branch
git fetch origin
git rebase origin/master

Fix conflicts:
git add .
git rebase --continue

7. Describe a scenario where you have to temporarily switch branches to work on a critical hotfix, but you don’t want to commit your half-done work. Explain how you would use git stash for this purpose and how you might use git cherry-pick to apply specific commits from one branch to another.

Stash work:
git stash
git checkout hotfix-branch

Restore:
git checkout feature-branch
git stash pop

Cherry-pick:
git cherry-pick <commit-hash>

8. Revert a Commit
git log
git revert <commit-hash>

9. Explain how to set up a pre-commit hook that runs a linting script before each commit is processed. Why might you want to set this up for a shared workflow, and what impact does it have on code quality?
.git/hooks/pre-commit
10.You notice a major bug relating to a commit made three commits ago with hash abc123. How would you use Git to investigate when the bug was introduced and fix it? Provide a detailed workflow including any relevant commands.
git show abc123
git bisect start
git bisect bad
git bisect good <good-commit>

11. Assume you are required to maintain a clean and concise commit history. Describe how you would use git rebase to rearrange, squash, or split commits.
git rebase -i HEAD~3
git reset HEAD^
git add <files>
git commit
git rebase --continue

12. You want to contribute to a public Git repository to which you don’t have write access. Explain how you would fork the repository, make changes in your fork, and then submit a pull request to the original repository. What would the workflow look like, including the commands?
git clone https://github.com/your/repo.git
cd repo
git remote add upstream https://github.com/original/repo.git

git checkout -b feature-xyz
git add .
git commit -m "Add feature"
git push origin feature-xyz
* */
}
