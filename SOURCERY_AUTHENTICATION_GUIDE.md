# Sourcery Authentication Guide - Updated 2024

## 🔍 Finding Your Sourcery Token

The URL structure for Sourcery has changed. Here are the correct ways to access your API token:

### Method 1: Dashboard (Recommended)
1. Go to: **https://app.sourcery.ai/dashboard**
2. Sign in or create an account
3. Look for:
   - Your profile/avatar (top right) → **Account Settings** → **API Tokens**
   - Or **Settings** → **API Tokens**
   - Or **Review Settings** → **API Tokens**

### Method 2: Direct Login
1. Go to: **https://app.sourcery.ai**
2. Sign in
3. Navigate to Dashboard → Account/Settings → API Tokens

### Method 3: If You Can't Find Token Section
Sourcery may use **GitHub App authentication** instead of tokens. In this case:
1. Skip the token step
2. Go directly to **Part 4: Connect Repository in Sourcery Dashboard**
3. Install the Sourcery GitHub App - it will handle authentication automatically

## 🎯 Do You Actually Need a Token?

### You DON'T need a token if:
- Your repository is **open source** (public)
- You're using **GitHub App authentication** (installed via Sourcery Dashboard)

### You DO need a token if:
- Your repository is **private**
- You're using the GitHub Action workflow directly (not via GitHub App)
- You want to use Sourcery CLI locally

## 🔧 Alternative Setup: GitHub App (No Token Required)

### Step 1: Install Sourcery GitHub App
1. Go to: **https://app.sourcery.ai/dashboard**
2. Click **"Add Repository"** or **"Connect Repository"**
3. You'll be redirected to GitHub
4. Click **"Install"** or **"Authorize"** Sourcery
5. Select which repositories to connect
6. Complete the installation

### Step 2: Update Workflow (If Using GitHub App)
If you're using GitHub App authentication, you might not need the token in the workflow. However, the current workflow should still work - the GitHub App will handle authentication automatically when installed.

## 📝 Updated Workflow Options

### Option A: With Token (Current Setup)
```yaml
token: ${{ secrets.SOURCERY_TOKEN }}
```
- Requires: Token in GitHub Secrets
- Works for: Both public and private repos

### Option B: Without Token (GitHub App)
If using GitHub App, you can try removing the token line:
```yaml
# token: ${{ secrets.SOURCERY_TOKEN }}  # Not needed with GitHub App
```
- Requires: Sourcery GitHub App installed
- Works for: Repositories connected via GitHub App

## 🆘 Still Can't Find Token?

### Contact Sourcery Support
- Email: **support@sourcery.ai**
- Documentation: **https://docs.sourcery.ai/**
- Ask about: "How to get API token for GitHub Actions integration"

### Try These Steps
1. **Check your Sourcery plan**: Some plans might not require tokens
2. **Use GitHub App instead**: Often easier and doesn't require token management
3. **Check Sourcery documentation**: The process may have changed recently

## ✅ Quick Test

After setup (with or without token):
1. Create a test branch
2. Make a small change
3. Create a PR
4. Check if Sourcery reviews appear

If reviews appear, your authentication is working correctly!

