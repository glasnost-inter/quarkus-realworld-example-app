# Step-by-Step: Adding Sourcery Token and Connecting Repository

## Part 1: Get Your Sourcery API Token

### Step 1.1: Access Sourcery Dashboard
1. Open your web browser
2. Go to: **https://app.sourcery.ai/dashboard**
   - **Note**: The URL structure may have changed. If this doesn't work, try:
     - https://sourcery.ai and navigate to Dashboard/Account Settings
     - Or sign in at https://app.sourcery.ai
3. If you're not logged in:
   - Click **Sign In** or **Sign Up**
   - Create an account if needed (you can use GitHub to sign in)

### Step 1.2: Find API Token Section
1. Once logged into the dashboard, look for:
   - **Account Settings** or **Settings** (usually in the top right menu)
   - **API Tokens** or **Authentication** section
   - Or **Review Settings** → **API Tokens**
2. If you can't find it, try:
   - Click on your profile/avatar in the top right
   - Look for "Account", "Settings", or "API" in the dropdown menu

### Step 1.3: Generate API Token
1. Once you find the API Tokens section, look for:
   - **"Generate New Token"** or
   - **"Create Token"** or
   - **"New Token"** button
2. Click the button
3. You may be asked to give the token a name (e.g., "GitHub Integration" or "Java Project")
4. Click **Generate** or **Create**
5. **IMPORTANT**: Copy the token immediately - it will only be shown once!
   - It will look something like: `sourcery_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx`
   - Save it in a secure place temporarily (you'll need it in Part 2)

### Alternative: If Token is Not Required
- **For open source projects**: You might not need a token at all
- **GitHub App Authentication**: Sourcery may use GitHub App authentication instead
- If you can't find the token section, you can proceed to Part 4 (Connect Repository) - the GitHub App installation might handle authentication automatically

---

## Part 2: Set Up Git Repository (If Not Already Done)

### Step 2.1: Initialize Git Repository
Open your terminal in the project directory and run:

```bash
cd /Users/salmanfarid/trail-sourcery/quarkus-realworld-example-app-main
git init
git add .
git commit -m "Initial commit with Sourcery integration"
```

### Step 2.2: Create GitHub Repository
1. Go to **https://github.com/new**
2. Fill in:
   - **Repository name**: `quarkus-realworld-example-app` (or your preferred name)
   - **Description**: (optional)
   - **Visibility**: Choose Public or Private
   - **DO NOT** initialize with README, .gitignore, or license (we already have files)
3. Click **Create repository**

### Step 2.3: Connect Local Repository to GitHub
After creating the GitHub repository, GitHub will show you commands. Use these:

```bash
# Replace YOUR_USERNAME and YOUR_REPO_NAME with your actual values
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
git branch -M main
git push -u origin main
```

**Example:**
```bash
git remote add origin https://github.com/johndoe/quarkus-realworld-example-app.git
git branch -M main
git push -u origin main
```

---

## Part 3: Add Token to GitHub Secrets

### Step 3.1: Navigate to Repository Settings
1. Go to your GitHub repository page (the one you just created)
2. Click on the **Settings** tab (at the top of the repository page)
   - If you don't see Settings, make sure you're the repository owner or have admin access

### Step 3.2: Access Secrets Section
1. In the left sidebar, scroll down to **Secrets and variables**
2. Click on **Actions** (under Secrets and variables)

### Step 3.3: Add New Secret
1. Click the **New repository secret** button (top right)
2. Fill in the form:
   - **Name**: `SOURCERY_TOKEN` (must be exactly this, case-sensitive)
   - **Secret**: Paste the token you copied in Part 1.2
3. Click **Add secret**
4. You should see a confirmation that the secret was added

---

## Part 4: Connect Repository in Sourcery Dashboard

### Step 4.1: Access Sourcery Dashboard
1. Go to **https://sourcery.ai/dashboard**
2. Make sure you're logged in with the same account you used in Part 1

### Step 4.2: Add Repository
1. Look for a button that says:
   - **"Add Repository"** or
   - **"Connect Repository"** or
   - **"Install on GitHub"**
2. Click the button
3. You'll be redirected to GitHub to authorize Sourcery
4. Click **Authorize** or **Install** when prompted
5. You may be asked to:
   - Select which repositories to connect (choose your repository)
   - Or it may automatically connect all repositories

### Step 4.3: Verify Connection
1. Go back to the Sourcery Dashboard
2. You should see your repository listed
3. Make sure **Pull Request Reviews** is enabled for your repository
   - There should be a toggle or checkbox next to your repository

---

## Part 5: Test the Integration

### Step 5.1: Create a Test Branch
```bash
git checkout -b test-sourcery-integration
```

### Step 5.2: Make a Small Change
Edit any Java file in `src/main/java` (add a comment or small change)

### Step 5.3: Commit and Push
```bash
git add .
git commit -m "Test Sourcery integration"
git push origin test-sourcery-integration
```

### Step 5.4: Create Pull Request
1. Go to your GitHub repository
2. You should see a banner suggesting to create a PR for your new branch
3. Click **Compare & pull request**
4. Fill in PR details and click **Create pull request**

### Step 5.5: Check for Sourcery Review
1. Wait a minute or two
2. Check the **Checks** tab in your PR - you should see "Sourcery Code Review" running
3. Once complete, check the **Files changed** tab - Sourcery should have added review comments
4. You can also check the **Actions** tab in your repository to see the workflow running

---

## Troubleshooting

### Token Not Working?
- Make sure you copied the **entire** token (it's usually quite long)
- Verify the secret name is exactly `SOURCERY_TOKEN` (case-sensitive)
- Try generating a new token if the old one doesn't work

### Repository Not Showing in Sourcery?
- Make sure you authorized Sourcery in GitHub
- Check that the repository is selected in Sourcery's GitHub App settings
- Try disconnecting and reconnecting the repository

### Workflow Not Running?
- Check the **Actions** tab in GitHub - look for any error messages
- Verify the workflow file exists at `.github/workflows/sourcery-review.yml`
- Make sure you've pushed the workflow file to GitHub

### No Review Comments?
- Wait a few minutes - Sourcery may take time to analyze
- Check that the workflow completed successfully in the Actions tab
- Verify your Sourcery account has an active subscription/plan

---

## Quick Reference: Token Format

Your Sourcery token should look like:
```
sourcery_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
```

It's typically 40+ characters long and starts with `sourcery_`.

---

## Need Help?

- **Sourcery Support**: https://sourcery.ai/support
- **Sourcery Docs**: https://docs.sourcery.ai/
- **GitHub Actions Docs**: https://docs.github.com/en/actions

