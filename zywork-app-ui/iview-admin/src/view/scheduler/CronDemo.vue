<template>
  <div v-if="showDemo">
    <Row>
      <i-col span="14">
        <strong>每半分钟触发一次：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'30 * * * * ?'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >30 * * * * ?</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'30 * * * * ?'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>每小时的10分30秒触发一次：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'30 10 * * * ?'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >30 10 * * * ?</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'30 10 * * * ?'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>每天1点10分30秒触发：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'30 10 1 * * ?'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >30 10 1 * * ?</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'30 10 1 * * ?'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>每月20号1点10分30秒触发：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'30 10 1 20 * ?'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >30 10 1 20 * ?</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'30 10 1 20 * ?'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>每年10月20号1点10分30秒触发：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'30 10 1 20 10 ? *'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >30 10 1 20 10 ? *</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'30 10 1 20 10 ? *'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>2019年1月20号1点10分30秒触发：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'30 10 1 20 1 ? 2019'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >30 10 1 20 1 ? 2019</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'30 10 1 20 1 ? 2019'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>2019年1月每天1点10分30秒触发：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'30 10 1 ? 1 * 2019'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >30 10 1 ? 1 * 2019</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'30 10 1 ? 1 * 2019'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>2019年1月每周日1点10分30秒触发：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'30 10 1 ? 1 SUN 2019'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >30 10 1 ? 1 SUN 2019</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'30 10 1 ? 1 SUN 2019'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>每15秒，30秒，45秒触发：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'15,30,45 * * * * ?'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >15,30,45 * * * * ?</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'15,30,45 * * * * ?'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>15到45秒内，每秒都触发：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'15-45 * * * * ?'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >15-45 * * * * ?</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'15-45 * * * * ?'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>每分钟的每15秒开始触发，每隔5秒触发一次：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'15/5 * * * * ?'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >15/5 * * * * ?</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'15/5 * * * * ?'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>每分钟的15秒到30秒之间开始触发，每隔5秒触发一次：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'15-30/5 * * * * ?'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >15-30/5 * * * * ?</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'15-30/5 * * * * ?'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>每小时的第0分0秒开始，每三分钟触发一次：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'0 0/3 * * * ?'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >0 0/3 * * * ?</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'0 0/3 * * * ?'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>星期一到星期五的10点15分0秒触发：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'0 15 10 ? * MON-FRI'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >0 15 10 ? * MON-FRI</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'0 15 10 ? * MON-FRI'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>每个月最后一天的10点15分0秒触发：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'0 15 10 L * ?'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >0 15 10 L * ?</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'0 15 10 L * ?'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>每个月最后一个工作日的10点15分0秒触发：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'0 15 10 LW * ?'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >0 15 10 LW * ?</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'0 15 10 LW * ?'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>每个月最后一个星期四的10点15分0秒触发：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'0 15 10 ? * 5L'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >0 15 10 ? * 5L</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'0 15 10 ? * 5L'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
    <Row>
      <i-col span="14">
        <strong>每个月第三周的星期四的10点15分0秒触发：</strong>
      </i-col>
      <i-col span="8">
        <Tooltip placement="top" content="点击复制">
          <i-button
            class="copyBtn"
            :data-clipboard-text="'0 15 10 ? * 5#3'"
            type="default"
            size="small"
            @click="prompt('复制成功', 'info')"
          >0 15 10 ? * 5#3</i-button>
        </Tooltip>
      </i-col>
      <i-col span="2">
        <i-button
          class="copyBtn"
          :data-clipboard-text="'0 15 10 ? * 5#3'"
          type="info"
          size="small"
          @click="prompt('复制成功', 'info')"
        >复制</i-button>
      </i-col>
    </Row>
  </div>
</template>
<script>
import Clipboard from 'clipboard';
let clipboard = new Clipboard('.copyBtn');
export default {
  name: 'CronDemom',
  props: {
    showDemo: false
  },
  data() {
    return {}
  },
  mounted() {},
  methods: {
    prompt(des, type) {
			if (type == "info") {
				this.$Message.info(des);
			} else if (type == "error") {
				this.$Message.error(des);
			} else if (type == "warning") {
				this.$Message.warning(des);
			}
		},
  }
}
</script>
