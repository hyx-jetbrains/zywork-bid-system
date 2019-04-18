<template>
  <div>
    <Card>
      <p slot="title">
        <Icon type="ios-ionitron"></Icon>Redis缓存管理
      </p>
      <a href="javascript:;" slot="extra" @click="searchKeys">
        <Icon type="ios-refresh"></Icon>刷新
      </a>
      <div class="demo-split">
        <Split v-model="splitDB">
          <div slot="left" class="demo-split-pane no-padding">
            <Split v-model="splitInfo" mode="vertical">
              <div slot="top" class="demo-split-pane">
                <Row style="margin-bottom: 10px;">
                  <i-col span="24">
                    <Input v-model="searchPattern" placeholder="请输入key搜索..." class="search-input" @on-enter="searchKeys" />
                    <InputNumber v-model="searchCount" placeholder="请输入搜索数量" style="width: 120px; margin-right: 5px;" @on-enter="searchKeys" />
                    <Button type="primary" icon="ios-search" @click="searchKeys" class="search-btn">搜索</Button>
                    <Tooltip content="清空缓存，谨慎操作" placement="bottom">
                      <Button type="error" icon="md-close" @click="deleteKeys">清空keys</Button>
                    </Tooltip>
                  </i-col>
                </Row>
                <Collapse simple @on-change="switchCollapse">
                  <Panel name="db">数据库-0（{{keysCount}}）
                    <p slot="content">
                      <Spin fix v-if="keysSpin"></Spin>
                      <Scroll height="160">
                        <Row>
                          <div v-for="item in keysList" :key="item.key">
                          <i-col span="10" class="server-key-key"  style="margin-bottom: 5px;">
                            <!-- <Button
                              type="text"
                              class="server-key"
                              @click="getValueByKey(item.key)"
                            >{{item.key}}</Button> -->
                            <a href="javascript:;" @click="getValueByKey(item.key)" class="server-key">{{item.key}}</a>
                          </i-col>
                          <i-col span="2">
                            <Tooltip content="删除缓存，谨慎操作" placement="left">
                              <!-- <Button type="text" icon="md-close" class="server-clear-key" @click="deleteKey(item.key)" /> -->
                              <a href="javascript:;" @click="deleteKey(item.key)" class="server-clear-key"><Icon type="md-close" /></a>
                            </Tooltip>
                          </i-col>
                          </div>
                        </Row>
                      </Scroll>
                    </p>
                  </Panel>
                </Collapse>
              </div>
              <div slot="bottom" class="demo-split-pane">
                <Divider class="server-value-divider"></Divider>
                <Row class="server-value-title">
                  <i-col span="2">
                    <strong class="server-value-key">Key:</strong>
                  </i-col>
                  <i-col span="22">{{valueInfo.key}}</i-col>
                </Row>
                <Divider class="server-value-divider"></Divider>
                <Row class="server-value-title">
                  <i-col span="2">
                    <strong class="server-value-key">Size:</strong>
                  </i-col>
                  <i-col span="22">{{valueInfo.size}}</i-col>
                </Row>
                <Divider class="server-value-divider"></Divider>
                <Row class="server-value-title">
                  <i-col span="2">
                    <strong class="server-value-key">TTL:</strong>
                  </i-col>
                  <i-col span="22">{{valueInfo.expire}}{{valueInfo.expireFormat}}</i-col>
                </Row>
                <Divider class="server-value-divider" style="margin-bottom: 0px;"></Divider>
                <Row class="server-value-value">
                  <i-col span="22">
                    <strong class="server-value-key">Value</strong>
                  </i-col>
                  <i-col span="2">
                    <Tooltip content="删除缓存，谨慎操作">
                      <Button type="text" icon="md-close" class="server-clear-key"/>
                    </Tooltip>
                  </i-col>
                </Row>
                <Divider class="server-value-divider" style="margin-top: 0px;"></Divider>
                <Row class="server-value-val">
                  <Scroll height="200">
                    <pre style="padding-left: 20px;">{{valueInfo.value}}</pre>
                  </Scroll>
                </Row>
              </div>
            </Split>
          </div>
          <div slot="right" class="demo-split-pane">
            <h3 class="server-info-title">
              <Row>
                <i-col span="12" style="text-align: left; padding-left: 15px;">
                  Redis 服务器信息
                </i-col>
                <i-col span="12" style="text-align: right; padding-right: 15px;">
                  <small>
                    <a href="javascript:;" @click="getRedisCacheInfo">
                      <Icon type="ios-refresh"></Icon>刷新
                    </a>
                  </small>
                </i-col>
              </Row>
            </h3>
            <Divider>基本信息</Divider>
            <Row class="server-info-title">
              <i-col span="12">
                <CellGroup>
                  <Cell title="Redis 版本" :label="redisInfo.redis_version"/>
                  <Cell title="已执行的命令" :label="redisInfo.total_commands_processed"/>
                </CellGroup>
              </i-col>
              <i-col span="12">
                <CellGroup>
                  <Cell title="已使用的内存" :label="redisInfo.used_memory_rss"/>
                  <Cell title="正常运行时间" :label="redisInfo.uptime_in_seconds"/>
                </CellGroup>
              </i-col>
            </Row>
            <Divider>详细信息</Divider>
            <CellGroup>
              <Scroll height="290">
              <Cell title="arch_bits" :extra="redisInfo.arch_bits"/>
              <Cell title="config_file" :extra="redisInfo.config_file"/>
              <Cell title="hz" :extra="redisInfo.hz"/>
              <Cell title="lru_clock" :extra="redisInfo.lru_clock"/>
              <Cell title="multiplexing_api" :extra="redisInfo.multiplexing_api"/>
              <Cell title="os" :extra="redisInfo.os"/>
              <Cell title="process_id" :extra="redisInfo.process_id"/>
              <Cell title="redis_build_id" :extra="redisInfo.redis_build_id"/>
              <Cell title="redis_git_drity" :extra="redisInfo.redis_git_dirty"/>
              <Cell title="redis_git_sha1" :extra="redisInfo.redis_git_sha1"/>
              <Cell title="redis_mode" :extra="redisInfo.redis_mode"/>
              <Cell title="redis_version" :extra="redisInfo.redis_version"/>
              <Cell title="run_id" :extra="redisInfo.run_id"/>
              <Cell title="tcp_port" :extra="redisInfo.tcp_port"/>
              <Cell title="uptime_in_days" :extra="redisInfo.uptime_in_days"/>
              <Cell title="uptime_in_seconds" :extra="redisInfo.uptime_in_seconds"/>
              </Scroll>
            </CellGroup>
          </div>
        </Split>
      </div>
    </Card>
  </div>
</template>

<script>
import './RedisCache.less'
var JWT_TOKEN = "jwt_token::"
import { 
  redisCacheInfo,
  redisCacheKeys,
  redisCacheKeysCount,
  getValueByKey,
  delKey,
  delKeys
} from '@/api/cache'
import * as ResponseStatus from '@/api/response-status'
export default {
  name: 'RedisCache',
  components: {},
  data() {
    return {
      splitDB: 0.6,
      splitInfo: 0.2,
      searchPattern: '*',
      searchCount: 1,
      redisInfo: {
        aof_rewrite_scheduled: 'N/A',
        number_of_cached_scripts: 'N/A',
        mem_clients_slaves: 'N/A',
        keyspace_misses: 'N/A',
        mem_allocator: 'N/A',
        multiplexing_api: 'N/A',
        aof_last_write_status: 'N/A',
        used_memory_peak_perc: 'N/A',
        run_id: 'N/A',
        uptime_in_seconds: 'N/A',
        maxmemory: 'N/A',
        active_defrag_hits: 'N/A',
        atomicvar_api: 'N/A',
        total_system_memory_human: 'N/A',
        gcc_version: 'N/A',
        second_repl_offset: 'N/A',
        arch_bits: 'N/A',
        master_repl_offset: 'N/A',
        instantaneous_output_kbps: 'N/A',
        total_commands_processed: 'N/A',
        repl_backlog_size: 'N/A',
        sync_full: 'N/A',
        sync_partial_err: 'N/A',
        aof_last_cow_size: 'N/A',
        configured_hz: 'N/A',
        used_memory_startup: 'N/A',
        mem_clients_normal: 'N/A',
        used_cpu_user: 'N/A',
        aof_enabled: 'N/A',
        redis_mode: 'N/A',
        rdb_changes_since_last_save: 'N/A',
        used_memory_lua: 'N/A',
        redis_build_id: 'N/A',
        connected_slaves: 'N/A',
        expired_keys: 'N/A',
        used_memory: 'N/A',
        active_defrag_misses: 'N/A',
        active_defrag_key_misses: 'N/A',
        used_memory_rss: 'N/A',
        rdb_last_bgsave_status: 'N/A',
        process_id: 'N/A',
        rejected_connections: 'N/A',
        master_replid: 'N/A',
        used_memory_rss_human: 'N/A',
        used_memory_scripts: 'N/A',
        rdb_bgsave_in_progress: 'N/A',
        rdb_last_cow_size: 'N/A',
        cluster_enabled: 'N/A',
        tcp_port: 'N/A',
        os: 'N/A',
        mem_replication_backlog: 'N/A',
        aof_current_rewrite_time_sec: 'N/A',
        allocator_rss_ratio: 'N/A',
        used_memory_overhead: 'N/A',
        repl_backlog_histlen: 'N/A',
        slave_expires_tracked_keys: 'N/A',
        used_cpu_sys: 'N/A',
        role: 'N/A',
        used_memory_dataset_perc: 'N/A',
        expired_stale_perc: 'N/A',
        allocator_frag_ratio: 'N/A',
        client_recent_max_input_buffer: 'N/A',
        aof_last_bgrewrite_status: 'N/A',
        used_memory_peak_human: 'N/A',
        hz: 'N/A',
        used_memory_human: 'N/A',
        maxmemory_policy: 'N/A',
        rss_overhead_ratio: 'N/A',
        mem_fragmentation_ratio: 'N/A',
        rdb_last_bgsave_time_sec: 'N/A',
        allocator_allocated: 'N/A',
        used_memory_dataset: 'N/A',
        blocked_clients: 'N/A',
        used_cpu_sys_children: 'N/A',
        repl_backlog_active: 'N/A',
        used_cpu_user_children: 'N/A',
        sync_partial_ok: 'N/A',
        aof_rewrite_in_progress: 'N/A',
        redis_git_sha1: 'N/A',
        rdb_current_bgsave_time_sec: 'N/A',
        active_defrag_running: 'N/A',
        aof_last_rewrite_time_sec: 'N/A',
        master_replid2: 'N/A',
        config_file: 'N/A',
        lazyfree_pending_objects: 'N/A',
        used_memory_scripts_human: 'N/A',
        loading: 'N/A',
        allocator_rss_bytes: 'N/A',
        db3: 'N/A',
        pubsub_channels: 'N/A',
        db1: 'N/A',
        used_memory_lua_human: 'N/A',
        db0: 'N/A',
        active_defrag_key_hits: 'N/A',
        allocator_frag_bytes: 'N/A',
        migrate_cached_sockets: 'N/A',
        redis_git_dirty: 'N/A',
        total_system_memory: 'N/A',
        mem_aof_buffer: 'N/A',
        rss_overhead_bytes: 'N/A',
        client_recent_max_output_buffer: 'N/A',
        connected_clients: 'N/A',
        mem_fragmentation_bytes: 'N/A',
        lru_clock: 'N/A',
        pubsub_patterns: 'N/A',
        expired_time_cap_reached_count: 'N/A',
        repl_backlog_first_byte_offset: 'N/A',
        total_net_output_bytes: 'N/A',
        executable: 'N/A',
        evicted_keys: 'N/A',
        total_connections_received: 'N/A',
        allocator_active: 'N/A',
        mem_not_counted_for_evict: 'N/A',
        redis_version: 'N/A',
        total_net_input_bytes: 'N/A',
        latest_fork_usec: 'N/A',
        maxmemory_human: 'N/A',
        used_memory_peak: 'N/A',
        allocator_resident: 'N/A',
        keyspace_hits: 'N/A',
        uptime_in_days: 'N/A',
        instantaneous_input_kbps: 'N/A',
        instantaneous_ops_per_sec: 'N/A',
        rdb_last_save_time: 'N/A'
      },
      keysList: '',
      keysCount: 0,
      keysSpin: false,
      valueInfo: {
        key: '',
        value: '',
        size: '',
        expire: '',
        expireFormat: ''
      },
      valueInterval: null
    }
  },
  computed: {},
  mounted() {
    this.getRedisCacheInfo()
    this.getKeysCount()
    // this.searchKeys()
  },
  beforeDestroy() {
    clearInterval(this.valueInterval)
  },
  methods: {
    // 切换数据库面板
    switchCollapse(keys) {
      if (keys.length === 0) {
        // 关闭面板
        this.splitInfo = 0.2
        this.keysList = ''
      } else {
        // 开启面板
        this.splitInfo = 0.4
        this.searchKeys()
      }
    },
    // 获取Redis缓存信息
    getRedisCacheInfo() {
      redisCacheInfo()
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.redisInfo = data.data
            this.redisInfo.uptime_in_days = this.redisInfo.uptime_in_days + "天"
            this.redisInfo.uptime_in_seconds = this.formaturDing(this.redisInfo.uptime_in_seconds)
            this.redisInfo.used_memory_rss = (this.redisInfo.used_memory_rss / 1024 / 1024).toFixed(2) + "M"
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    // 获取key的个数
    getKeysCount() {
      redisCacheKeysCount()
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.keysCount = data.data
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    // 查询key
    searchKeys() {
      if (this.searchCount === null) {
        this.searchCount = 1
      }
      var params = {
        count: this.searchCount,
        pattern : this.searchPattern
      }
      this.keysSpin = true
      redisCacheKeys(params)
        .then(res => {
          this.keysSpin = false
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.getKeysCount()
            if (data.data.total === 0) {
              this.$Message.error('未获取到key')
              return
            }
            this.valueInfo = ''
            this.keysList = data.data.rows
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    // 根据key查询value的值信息
    getValueByKey(key) {
      if (key === '') {
        this.$Message.error('key为空')
        return
      }
      var params = {
        key: key
      }
      if (this.valueInterval != null) {
        clearInterval(this.valueInterval)
      }
      getValueByKey(params)
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.valueInfo = data.data
            if (this.valueInfo.expire !== -1) {
              let time = (this.valueInfo.expire / 1000).toFixed(0)
              this.valueInfo.expire = time + " s"
              this.valueInfo.expireFormat = "（" + this.formaturDing(time) + "）"
              this.valueInterval = setInterval(() => {
                time -= 1
                this.valueInfo.expire = time + " s"
                this.valueInfo.expireFormat = "（" + this.formaturDing(time) + "）"
              }, 1000)
            }
            this.valueInfo.size = this.valueInfo.size + " byte"
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    // 删除key
    deleteKey(key) {
      if (key === '') {
        this.$Message.error('key为空')
        return
      }
      if (key.indexOf(JWT_TOKEN) != -1) {
        this.$Message.error("该缓存不可删除")
        return
      }
      var params = {
        key: key
      }
      delKey(params)
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.$Message.info(data.message)
            this.searchKeys()
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    // 清空缓存
    deleteKeys() {
      if (this.keysCount <= 0 || this.keysList.length <= 0) {
        this.$Message.error("未获取到缓存，不需要清空")
        return
      }
      var keys = [];
      this.keysList.forEach(key => {
        if (key.key.indexOf(JWT_TOKEN) == -1) {
          keys.push(key.key)
        }
      })
      var params = {
        keys: keys
      }
      delKeys(keys)
        .then(res => {
          const data = res.data
          if (data.code === ResponseStatus.OK) {
            this.$Message.info(data.message)
            this.searchKeys()
          } else {
            this.$Message.error(data.message)
          }
        })
        .catch(err => {
          this.$Message.error(err)
        })
    },
    // 格式化时间
		formaturDing(mss) {
			var days = parseInt(mss / (60 * 60 * 24))
			var hours = parseInt((mss % (60 * 60 * 24)) / (60 * 60))
			var minutes = parseInt((mss % (60 * 60)) / 60)
			var seconds = mss % 60
			return days + ' 天 ' + hours + ' 小时 ' + minutes + ' 分 ' + seconds + ' 秒 '
		}
  }
}
</script>
