# City Use Case 7 Produce the top N populated cities in a region where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a client I want to produce a report which display the top N populated cities in a region where N is provided by the user.* so that *I can easily find population.*

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains current world populations.

### Success End Condition

A report is available for client to view countries.

### Failed End Condition

No report is produced.

### Primary Actor

client

### Trigger

A request for world population is sent to client.

## MAIN SUCCESS SCENARIO

1. Information for the top N populated cities in a region is requested.
2. Database creates a report ordering all world by population.
3. Client provides report requested.

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 4.0