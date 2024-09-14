# Metagraph_NFT_Chain


## Welcome to Euclid Development Environment

basically the flow I want to have for
* MINT NFT 
* frontend calls blockchain -- create NFT (pdf data, NFT image,model name,Name of NFT) -- verify using key /Post request 
* blockchain calls backend(ngrok url) and sends data like pdf and model name 
* backend sends RAG back to the blockchain 
* chain stores NFT NAME, RAG, Image, PDF" in NFT created

Start Chat 
* frontend class --- blockchain -- start_chat(NFT ID) 
* blockchain sends pdf and rag to backend backend send a key to blockchain
* blockchain send the key to frontend

Are these flow getting implemented correctly 
what all changes are required

also check build.sbt for errors and tell me about the files that need to be rewritten and changed completely and what exactly to write there


> In WSL dont make this folder on mounted drive


## Setup

### Clone Euclid repository

```bash
git clone https://github.com/Constellation-Labs/euclid-development-environment
cd euclid-development-environment
```

### Create Github token

1. Go to [Github Personal Access Tokens]
2. Click on `Generate new token`
3. Select `repo` and `read:packages` scopes
4. Click on `Generate token`
5. Copy the token

paste in `euclid-development-environment\euclid.json`

### run and deploy

cd to the cloned directory and run the following commands


1. Hydra scipts
```bash
scripts/hydra -h
```

2. install template

```
scripts/hydra install-template
```

```
scripts/hydra install-template nft in this case
```


This will create a new directory in Source which your project name and also detach .git so that you can push it to your own repository

3. Modify the `euclid.json` file with your own values

4. Build the applications
```
scripts/hydra build
```

This will build the applications and create a docker image for the backend 
It also contains the smart contract code that is in the source directory

5. Deploy the applications
```
scripts/hydra start-genesis
```



get private key

pkcs12 -provider legacy -provider default -in token-key.p12 -nocerts -nodes -out privatekey.key


# for privare key use Eth keys


- harsh chats have code ...

- 

```mermaid

graph TD
    UI[User Interface]
    FA[Frontend Application]
    %% SC[Smart Contracts / Canisters]
    %% NS[NFT Storage]
    MN[Load Balancer]
    SN1[High Performing Node 1]
    SN2[High Performing Node 2]
    SN3[High Performing Node 3]
    %% SN4[Server Node 3]
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
    %% FA --> SC
    FA --"Blockchain Interaction"--> L0

    %% SC --> NS
    %% SC --> MN
    %% MN <--> L0
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
    %% L1C --> L0
    %% L1D --> L0
    %% L0 --> HG
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
        %% HG
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



    %% subgraph "Constellation Metagraph"
    %%     SC
    %%     NS
    %% end

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


    %% %% Connections
    %% FA -.-> MN
    %% L1D -.-> SN1
    %% L1D -.-> SN2
    %% L1D -.-> SN3

    MN -."Task Distribution".-> SN1
    MN -."Task Distribution".-> SN2
    MN -."Task Distribution".-> SN3
    MN -."Model Interaction".-> UI
    SN1 --> V
    SN1 -."Processing".-> MT
    %% SN1 -. "Processing" .-> MT
    %% SN2 -. "Processing" .-> V
    %% SN3 -. "Processing" .-> I
    %% ServerNode3 -. "Processing" .-> FineTuning

    


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
    %% class L1C,L1D metagraph;
    class MN,SN1,SN2,SN3 computing;
    class MT,V,I,FT components;

```


Create Account using Stargazer Wallet and copy the private key to setup balance in genesis

euclid-development-environment/source/metagraph-l0/genesis/genesis.csv
