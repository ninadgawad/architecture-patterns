# AGENTS.md — Repository Agent Guide

Purpose
- Explain how to use automated agents (Copilot, custom agents) with this repository.

Agents
- Explore — Fast read-only codebase exploration and Q&A subagent. Use for initial discovery (quick/medium/thorough).

How to use
- Ask the agent to perform small, focused tasks (create, update, explain files).
- For multi-step work, open an issue and assign the agent to follow the plan in the issue.

Conventions
- Agent edits should be staged on a feature branch named `feature/<short-description>`.
- Commit messages for agent-made changes should start with `chore(agent):` or `feat(agent):`.

Security & Review
- All agent-created changes require a human review before merging.
- Agents must not commit secrets or credentials. If an agent requests secrets, stop and provide them manually.

Contact
- Repo owner: ninadgawad (GitHub)

