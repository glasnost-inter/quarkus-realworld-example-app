# Sourcery GitHub Integration Setup Guide

This guide will help you set up Sourcery's GitHub integration for Java code reviews.

## ✅ What's Been Configured

1. **GitHub Actions Workflow** (`.github/workflows/sourcery-review.yml`)
   - Automatically runs Sourcery reviews on pull requests and pushes
   - Configured to review Java code in `src/main/java`

2. **Sourcery Configuration** (`.sourcery.yaml`)
   - Updated to ignore Java build artifacts (`target/`, `*.class`)
   - GitHub integration settings enabled
   - Python-specific settings commented out

## 🔧 Setup Steps

### 1. Get Your Sourcery API Token

1. Go to [https://sourcery.ai/account/api-tokens](https://sourcery.ai/account/api-tokens)
2. Sign in or create a Sourcery account
3. Generate a new API token
4. Copy the token (you'll need it in the next step)

### 2. Add Token to GitHub Secrets

1. Go to your GitHub repository
2. Navigate to **Settings** → **Secrets and variables** → **Actions**
3. Click **New repository secret**
4. Name: `SOURCERY_TOKEN`
5. Value: Paste your Sourcery API token
6. Click **Add secret**

### 3. Initialize Git Repository (if not already done)

If this isn't a git repository yet:

```bash
git init
git add .
git commit -m "Initial commit with Sourcery integration"
```

### 4. Push to GitHub

1. Create a new repository on GitHub (if you haven't already)
2. Add the remote:
   ```bash
   git remote add origin <your-github-repo-url>
   git branch -M main
   git push -u origin main
   ```

### 5. Enable Sourcery in GitHub

1. Go to [Sourcery Dashboard](https://sourcery.ai/dashboard)
2. Connect your GitHub repository
3. Enable "Pull Request Reviews" in the repository settings

## 🎯 How It Works

- **On Pull Requests**: Sourcery will automatically review all Java code changes
- **On Push**: Sourcery will review code pushed to main/master/develop branches
- **Review Comments**: Sourcery will post AI-powered review comments directly on your PRs

## 📝 Important Notes

- **Language Support**: Sourcery provides AI-powered code reviews for Java, but specialized static analysis rules are limited to Python, JavaScript, and TypeScript
- **Review Types**: You'll get general code quality, security, complexity, and best practice suggestions
- **Customization**: You can customize review settings in the [Sourcery Dashboard](https://sourcery.ai/dashboard)

## 🔍 Testing the Integration

1. Create a test branch:
   ```bash
   git checkout -b test-sourcery-integration
   ```

2. Make a small change to a Java file in `src/main/java`

3. Commit and push:
   ```bash
   git add .
   git commit -m "Test Sourcery integration"
   git push origin test-sourcery-integration
   ```

4. Create a Pull Request on GitHub

5. Check the PR - Sourcery should automatically add review comments

## 🛠️ Troubleshooting

- **No reviews appearing?** Check that:
  - The `SOURCERY_TOKEN` secret is set correctly
  - The repository is connected in the Sourcery Dashboard
  - The GitHub Actions workflow is running (check the Actions tab)

- **Workflow failing?** Check the Actions logs for error messages

## 📚 Additional Resources

- [Sourcery Documentation](https://docs.sourcery.ai/)
- [Sourcery GitHub Action](https://github.com/sourcery-ai/action)
- [Sourcery Code Review Guide](https://docs.sourcery.ai/Code-Review/Overview/)

