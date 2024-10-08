package com.my.nft.shared_data.types

import derevo.circe.magnolia.{decoder, encoder}
import derevo.derive
import org.tessellation.currency.dataApplication.{DataCalculatedState, DataOnChainState, DataUpdate}
import org.tessellation.schema.address.Address

object Types {
  @derive(decoder, encoder)
  case class NFT(
    id                   : Long,
    collectionId         : String,
    owner                : Address,
    uri                  : String,
    name                 : String,
    description          : String,
    creationDateTimestamp: Long,
    metadata             : Map[String, String],
    AI_data              : String,
  )

  @derive(decoder, encoder)
  case class Collection(
    id                   : String,
    owner                : Address,
    name                 : String,
    creationDateTimestamp: Long,
    nfts                 : Map[Long, NFT],
    description          : String,
    baseModel            : String,
    uri                  : String,
  )

  @derive(decoder, encoder)
  sealed trait NFTUpdate extends DataUpdate

  @derive(decoder, encoder)
  case class MintCollection(
    name: String,
    description: String,
    baseModel: String,
    uri: String
  ) extends NFTUpdate

  @derive(decoder, encoder)
  case class MintNFT(
    owner       : Address,
    collectionId: String,
    nftId       : Long,
    uri         : String,
    name        : String,
    description : String,
    metadata    : Map[String, String],
    AI_data              : String,
  ) extends NFTUpdate

  @derive(decoder, encoder)
  case class TransferCollection(
    fromAddress : Address,
    toAddress   : Address,
    collectionId: String
  ) extends NFTUpdate

  @derive(decoder, encoder)
  case class TransferNFT(
    fromAddress : Address,
    toAddress   : Address,
    collectionId: String,
    nftId       : Long
  ) extends NFTUpdate

  @derive(decoder, encoder)
  case class NFTUpdatesState(
    updates: List[NFTUpdate]
  ) extends DataOnChainState

  @derive(decoder, encoder)
  case class NFTUpdatesCalculatedState(
    collections: Map[String, Collection]
  ) extends DataCalculatedState

  @derive(decoder, encoder)
  case class CollectionResponse(
    id                   : String,
    owner                : Address,
    name                 : String,
    creationDateTimestamp: Long,
    numberOfNFTs         : Long,
    description          : String,
    baseModel            : String,
    uri                  : String,
  )

  @derive(decoder, encoder)
  case class NFTResponse(
    id                   : Long,
    collectionId         : String,
    owner                : Address,
    uri                  : String,
    name                 : String,
    description          : String,
    creationDateTimestamp: Long,
    metadata             : Map[String, String],
    // AI_data              : String,
    // apiResult            : String
  )


  @derive(decoder, encoder)
  case class ApiResponse(
    hpcEndpoint                   : String,
    hpcEndpointPort               : String, 
    apiKey                        : String
  )


  @derive(decoder, encoder)
  case class DecentralizedTestingResult(
    output                   : String,
  )

}
