# NeuraNFT: Tokenizing Intelligence on Metagraph_NFT_Chain

## Table of Contents

1. [Introduction](#introduction)
2. [Architecture Overview](#architecture-overview)
3. [Key Components](#key-components)
4. [Technical Architecture](#technical-architecture)
5. [Use Cases](#use-cases)
6. [Benefits](#benefits)
7. [Current Prototype](#current-prototype)
8. [Future Roadmap](#future-roadmap)
9. [Setup and Installation](#setup-and-installation)
10. [Usage](#usage)
11. [Contributing](#contributing)
12. [License](#license)

## Introduction

NeuraNFT is an innovative decentralized AI system built on Constellation Network's Metagraph architecture. It addresses the growing demand for personalized, secure, and decentralized artificial intelligence by combining blockchain technology with a decentralized infrastructure for secure deployment of machine learning models.

NeuraNFT leverages Non-Fungible Tokens (NFTs) to encapsulate fine-tuning data and model information, creating a unique ecosystem enabling users to own, customize, and securely access their AI models. The system harnesses Constellation's Metagraph architecture and Directed Acyclic Graph (DAG) based consensus for model training and inference.

## Architecture Overview

```mermaid
graph TD
    UI[User Interface]
    FA[Frontend Application]
    MN[Load Balancer]
    SN1[High Performing Node 1]
    SN2[High Performing Node 2]
    SN3[High Performing Node 3]
    MT[Model Training]
    V[Vectorization]
    I[Inference]
    FT[Fine-tuning]
    L0[Metagraph L0]
    L1C[Currency Layer L1]
    L1D[Data Layer L1]
    HG[Hypergraph]
    B1[Block 1]
    B2[Block 2]
    SN[Snap]
    CU[Custom data]
    TR[TRX]

    UI --> FA
    FA --"Blockchain Interaction"--> L0
    MN --"Data Read"--> L0
    MN --"Data Store"--> L1D
    MN --> SN1
    MN --> SN2
    MN --> SN3
    SN1 --> MT
    SN2 --> I
    SN2 -."Processing".-> V
    SN3 -."Processing".-> FT
    SN3 -."Processing".-> I
    SN3 --> I
    SN3 --> FT
    L1C --> B2
    L1D --> B1
    B1 --> L0
    B2 --> L0
    L0 --> SN
    SN -->HG
    TR --"Transaction"--> L1C
    CU --"Custom data"--> L1D
    FA -."Fetch".-> L1D

    subgraph "Blockchain"
        subgraph "Metagraph"
            L1C
            L1D
            L0
            B1
            B2
        end
        SN
        HG
    end

    subgraph "User Interaction"
        UI
        FA
    end

    subgraph "High-Performance Computing"
        MN
        SN1
        SN2
        SN3
    end

    subgraph "Key Components"
        MT
        V
        I
        FT
    end

    classDef default fill:#f9f,stroke:#333,stroke-width:2px,color:#000;
    classDef metagraph fill:#ffd700,stroke:#333,stroke-width:2px,color:#000;
    classDef computing fill:#87cefa,stroke:#333,stroke-width:2px,color:#000;
    classDef meta fill:#87cefa,stroke:#333,stroke-width:2px,color:#000;
    classDef data fill:#ffd700,stroke:#333,stroke-width:2px,color:#000;
    classDef Trx fill:#90EE90,stroke:#000000,color:#000;
    classDef components fill:#ffa07a,stroke:#333,stroke-width:2px;

    class L1D,CU data;
    class L1C,TR Trx;
    class L0,HG,B1,B2 meta;
    class MN,SN1,SN2,SN3 computing;
    class MT,V,I,FT components;
```

## Key Components

1. Constellation Network and Metagraph Architecture
   - DAG-based Consensus
   - Metagraph Architecture
   - Global L0
   - HTTPS Outcalls
   - Custom Token Creation

2. NFT-based AI Models
   - Unique Identity
   - Ownership and Control
   - Transferability
   - Versioning and Upgradeability
   - Privacy

3. High-Performance Computing (HPC) Infrastructure
   - Current Prototype: Single HPC node
   - Future: Distributed network of HPC nodes
   - Blockchain-based Compute System
   - Scalability

4. Custom Metagraph Logic
   - AI Model Management
   - Access Control
   - Token Operations
   - Data Processing
   - API Integration

## Technical Architecture

NeuraNFT's technical architecture consists of several interconnected Metagraphs:

1. Core Metagraph
   - NFT Management
   - Ownership Registry
   - Metadata Storage
   - Access Control

2. AI Compute Metagraph
   - Model Training
   - Inference Requests
   - Compute Resource Allocation
   - Validation Logic

3. User Data Metagraph
   - Personal Data Storage
   - Access Control
   - Data Preprocessing
   - Consent Management

These Metagraphs interact through Constellation's Global L0 layer, enabling a modular and scalable architecture.

## Use Cases

1. Personalized AI Assistants
2. Secure Enterprise AI
3. AI Model Marketplace
4. Decentralized Research Collaboration
5. Privacy-Preserving Personal Analytics
6. Customized Education and Training
7. Decentralized Autonomous Organizations (DAOs)

## Benefits

1. Enhanced Data Privacy and Security
2. True Ownership of AI Models
3. Transparency and Auditability
4. Decentralized Infrastructure
5. Interoperability and Composability
6. Democratization of AI
7. Fair Compensation for Model Creation
8. Reduced Centralized Control
9. Continuous Improvement and Versioning
10. Regulatory Compliance

## Current Prototype

The current prototype demonstrates core functionality using a single HPC node implementation. It serves as a proof of concept and foundation for future development.

### Mint NFT Flow
1. Frontend calls blockchain to create NFT (pdf data, NFT image, model name, Name of NFT)
2. Blockchain verifies using key/Post request
3. Blockchain calls backend (ngrok url) and sends data like pdf and model name
4. Backend sends RAG back to the blockchain
5. Chain stores NFT NAME, RAG, Image, PDF in the created NFT

### Start Chat Flow
1. Frontend calls blockchain - start_chat(NFT ID)
2. Blockchain sends pdf and rag to backend
3. Backend sends a key to blockchain
4. Blockchain sends the key to frontend

## Future Roadmap

1. Distributed HPC Network
2. Blockchain-Based Compute System
3. Advanced NFT Functionality
4. AI Model Marketplace
5. Governance and DAO Integration
6. Interoperability and Standards
7. Privacy and Security Enhancements
8. Ethical AI and Compliance Framework
9. Advanced AI Capabilities
10. Real-World Integration

## Setup and Installation

### Prerequisites
- Git
- GitHub account with personal access token

### Clone Euclid repository

```bash
git clone https://github.com/Constellation-Labs/euclid-development-environment
cd euclid-development-environment
```

### Create Github token

1. Go to [Github Personal Access Tokens](https://github.com/settings/tokens)
2. Click on `Generate new token`
3. Select `repo` and `read:packages` scopes
4. Click on `Generate token`
5. Copy the token

Paste the token in `euclid-development-environment\euclid.json`

### Installation Steps

1. View Hydra scripts help:
```bash
scripts/hydra -h
```

2. Install template:
```bash
scripts/hydra install-template nft
```

This will create a new directory in Source with your project name and also detach .git so that you can push it to your own repository.

3. Modify the `euclid.json` file with your own values

4. Build the applications:
```bash
scripts/hydra build
```

This will build the applications and create a docker image for the backend. It also contains the smart contract code that is in the source directory.

5. Deploy the applications:
```bash
scripts/hydra start-genesis
```

### Additional Notes

- To get the private key:
```
pkcs12 -provider legacy -provider default -in token-key.p12 -nocerts -nodes -out privatekey.key
```

- For private keys, use Eth keys

- In WSL, don't make this folder on a mounted drive

## Usage

(Here, you would include instructions on how to use the application, including any CLI commands, API endpoints, or user interface instructions.)

## Contributing

We welcome contributions to the NeuraNFT project! Please read our contributing guidelines before submitting pull requests.

## License

(Include information about the project's license here.)

---

For more detailed information about the project, please refer to our [whitepaper](link-to-whitepaper).

For questions or support, please [open an issue](link-to-issues) or contact us at [contact email].
