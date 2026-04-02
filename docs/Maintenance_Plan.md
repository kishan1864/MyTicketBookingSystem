# Maintenance Plan

## 1. Application Monitoring
- Monitor database connection pools.
- Evaluate slow JPA query logs to add indices on frequently queried rows (e.g. `show_time`, `movie_id`).

## 2. Backup & Archival Strategy
- **Daily Incremental Backups**: Trigger database dumps using `mysqldump`.
- **Archival**: Expired `ShowTiming` records and their related `Ticket`s should be moved to an archive table every 6 months to ensure table scans hit optimal rows.

## 3. Dependency Updates
- Regular assessment of Spring Boot patch versions using `mvn versions:display-dependency-updates`.
- Apply MySQL connector security patches.

## 4. Disaster Recovery
- Multi-AZ (Availability Zone) deployment recommendations if moving beyond single Ubuntu/Windows server deployment.
- Re-hydrate a failover database instance weekly to prove RTO/RPO metrics.
