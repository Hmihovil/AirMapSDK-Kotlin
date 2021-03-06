package com.airmap.sdk.models

import com.aungkyawpaing.geoshi.model.Geometry
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class Flight(
    @Json(name = "id") val id: FlightId,
    @Json(name = "flight_plan_id") val flightPlanId: FlightPlanId? = null,
    @Json(name = "pilot_id") val pilotId: PilotId,
    @Json(name = "pilot") val pilot: Pilot?,
    @Json(name = "latitude") val latitude: Degrees,
    @Json(name = "longitude") val longitude: Degrees,
    @Json(name = "max_altitude") val maxAltitude: Meters,
    @Json(name = "aircraft") val aircraft: Aircraft? = null,
    @Json(name = "aircraft_id") val aircraftId: String? = null,
    @Json(name = "created_at") val createdAt: Date,
    // TODO: Need to use "now" for start_time value if start_time is in the past/close to now during flight creation
    @Json(name = "start_time") val startTime: Date,
    @Json(name = "end_time") val endTime: Date,
    @Json(name = "city") val city: String?,
    @Json(name = "state") val state: String?,
    @Json(name = "country") val country: String?,
    @Json(name = "buffer") val buffer: Meters?,
    @Json(name = "notify") val notify: Boolean?,
    @Json(name = "public") val isPublic: Boolean?,
    @Json(name = "permits") val permits: List<String> = listOf(),
    @Json(name = "statuses") val statuses: List<Status> = listOf(),
    @Json(name = "geometry") val geometry: Geometry?,
) {
    @JsonClass(generateAdapter = true)
    data class Status(
        @Json(name = "id") val id: FlightStatusId,
        @Json(name = "manager_id") val managerId: String,
        @Json(name = "status") val status: Type,
    ) {
        enum class Type {
            @Json(name = "accepted") Accepted,
            @Json(name = "rejected") Rejected,
            @Json(name = "pending") Pending,
        }
    }
}

@JsonClass(generateAdapter = true)
data class FlightPlan(
    @Json(name = "id") val id: FlightPlanId? = null,
    @Json(name = "pilot_id") val pilotId: PilotId? = null,
    @Json(name = "flight_id") val flightId: FlightId? = null,
    @Json(name = "aircraft_id") val aircraftId: AircraftId? = null,
    @Json(name = "start_time") val startTime: Date? = null,
    @Json(name = "end_time") val endTime: Date? = null,
    @Json(name = "created_at") val createdAt: Date? = null,
    @Json(name = "creation_date") val creationDate: Date? = null,
    @Json(name = "buffer") val buffer: Meters? = null,
    @Json(name = "takeoff_latitude") val takeoffLatitude: Degrees? = null,
    @Json(name = "takeoff_longitude") val takeoffLongitude: Degrees? = null,
    @Json(name = "geometry") val geometry: Geometry? = null,
    @Json(name = "min_altitude_agl") val minAltitudeAgl: Meters? = null,
    @Json(name = "max_altitude_agl") val maxAltitudeAgl: Meters? = null,
    @Json(name = "rulesets") val rulesetIds: List<String>? = null,
    @Json(name = "flight_description") val flightDescription: String? = null,
    @Json(name = "flight_features") val flightFeatures: Map<String, Any?>? = null,
    @Json(name = "public") val isPublic: Boolean? = null,
    @Json(name = "notify") val shouldNotify: Boolean? = null,
)

@JsonClass(generateAdapter = true)
data class FlightBriefing(
    @Json(name = "flight_plan_id") val flightPlanId: String?,
    @Json(name = "color") val color: String?,
    @Json(name = "created_at") val createdAt: Date?,
    @Json(name = "rulesets") val rulesets: List<Ruleset> = listOf(),
    @Json(name = "airspace") val airspace: Airspace.Status?,
    @Json(name = "authorizations") val authorizations: List<Authorization> = listOf(),
)
